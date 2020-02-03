package com.aircos.config.security;

import com.aircos.entity.dao.User;
import com.aircos.enums.ResultCode;
import com.aircos.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 登录用户查询
 *
 * @author 龚国玮
 */
@Slf4j
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        User user = userService.findByPhone(phone);
        if (null == user) {
            throw new UsernameNotFoundException(ResultCode.ACCOUNT_NOT_EXIST.getMessage());
        } else {
            return new SecurityUserDetails(user);
        }
    }
}