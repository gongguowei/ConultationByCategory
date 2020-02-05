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
     * @param mobile 手机号
     * @param code 消息验证码
     * @throws ClientException
     */
    void sendMessage(String mobile, Integer code) throws ClientException;

}
