package com.aircos.config.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * JWT密码加密处理器
 *
 * @author 龚国玮
 */
public class JWTPasswordEncoder implements PasswordEncoder {

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Override
    public String encode(CharSequence charSequence) {
        return bCryptPasswordEncoder.encode(charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        //charSequence是前端传过来的密码，s是数据库中查到的密码
        return  bCryptPasswordEncoder.matches(charSequence, s);
    }
}
