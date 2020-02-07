package com.aircos.manager.impl;

import com.aircos.manager.SmsManager;
import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 短信管理
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-05
 */
@Service
public class SmsManagerImpl implements SmsManager {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 产品名称:云通信短信API产品,开发者无需替换
     */
    static final String product = "Dysmsapi";

    /**
     * 产品域名,开发者无需替换
     */
    static final String domain = "dysmsapi.aliyuncs.com";

    /**
     * Key
     */
    private final static String YUNPIAN_APIKEY="987e3464e67227a6bdc75481314378ab";

    /**
     * 验证码长度
     */
    private final static int RANDOMSIZE=6;

    /**
     *  TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
     * @return
     */
    static final String accessKeyId = "yourAccessKeyId";
    static final String accessKeySecret = "yourAccessKeySecret";

    @Override
    public void sendMessageForAlibaba(String mobile, Integer code) throws ClientException {
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(mobile);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("云通信");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_1000000");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"" + code + "+\"}");

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
    }

    @Override
    public String sendMessageForYunPian(String mobile) {

        //初始化clnt,使用单例方式
        YunpianClient clnt = new YunpianClient(YUNPIAN_APIKEY).init();

        //生成短信验证码
        String verifyCode = createRandomBySize(RANDOMSIZE);
        redisTemplate.opsForValue().set(mobile, verifyCode, 10*60, TimeUnit.SECONDS);

        //发送短信API
        Map<String, String> param = clnt.newParam(3);
        String message = String.format("【云航科技】"+ verifyCode +"(#app#手机验证码，请完成验证)，如非本人操作，请忽略本短信");
        param.put(YunpianClient.MOBILE, mobile);
        param.put(YunpianClient.TEXT, message);
        Result<SmsSingleSend> r = clnt.sms().single_send(param);
        clnt.close();
        if (r.getCode()!=0){
            return "error";
        }
        return verifyCode;
    }

    /**
     * 根据size长度生成随机数字字符串
     *
     * @param size 长度
     * @return
     */
    public static String createRandomBySize(int size){
        if (size<=0){
            size=1;
        }
        int bound=1;
        for (int i=1;i<size;i++){
            bound=bound*10;
        }
        //生成短信验证码
        String verifyCode = String
                .valueOf(new Random().nextInt((bound*10)-(bound+1)) + bound);
        return verifyCode;
    }
}
