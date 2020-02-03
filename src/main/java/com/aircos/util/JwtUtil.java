package com.aircos.util;

import com.aircos.constant.CommonConstant;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * token的工具类
 *
 * @author 龚国玮
 */
public class JwtUtil {

    /**
     * 加密生成token
     * @param openId
     * @param map
     * @return
     */
    public static String encrypt(String openId, Map<String, Object> map){
        return CommonConstant.TOKEN_SPLIT + Jwts.builder()
                //主题 放入用户名
                .setSubject(openId)
                //自定义属性 放入用户信息
                .claim(CommonConstant.AUTHORITIES, map)
                //失效时间
                .setExpiration(new Date(System.currentTimeMillis() + CommonConstant.JWT_TIME))
                //签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, CommonConstant.JWT_KEY)
                .compact();
    }

    /**
     * 解密token
     * @param token
     * @return
     */
    public static JSONObject decrypt(String token){
        try {
            // 解析token
            Claims claims = Jwts.parser()
                    .setSigningKey(CommonConstant.JWT_KEY)
                    .parseClaimsJws(token.replace(CommonConstant.TOKEN_SPLIT, ""))
                    .getBody();
            return new JSONObject(){{
                put("success", true);
                put("data", claims);
            }};
        } catch (ExpiredJwtException e) {
            return new JSONObject(){{
                put("success", false);
                put("code", 401);
                put("message", "登录已失效，请重新登录");
            }};

        } catch (Exception e){
            return new JSONObject(){{
                put("success", false);
                put("code", 500);
                put("message", "解析token错误");
            }};
        }
    }

}