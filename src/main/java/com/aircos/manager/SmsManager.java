package com.aircos.manager;

import com.aliyuncs.exceptions.ClientException;

/**
 * 短信管理
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-05
 */
public interface SmsManager {

    /**
     * 阿里云：发送验证码短信
     *
     * @param mobile 手机号码
     * @param code 消息验证码
     * @throws ClientException
     */
    void sendMessageForAlibaba(String mobile, Integer code) throws ClientException;

    /**
     * 云片网：发送验证码短信
     *
     * @param mobile 手机号码
     * @return 成功的话返回验证码，失败的话返回 error字符串
     */
    String sendMessageForYunPian(String mobile);

}
