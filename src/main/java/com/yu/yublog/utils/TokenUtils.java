package com.yu.yublog.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yu.yublog.pojo.User;

import java.util.Date;

/**
 * @Author: zl-yu
 * @Date: 2022/9/19 15:20
 * @Description: TODO
 */
public class TokenUtils {
    //token到期时间12小时
    private static final long SURVIVAL_TIME = 12*60*60*1000;
    //密钥盐
    private static final String TOKEN_SECRET ="fuhskdkf**jssxn?/0";

    /**
     * 生成token
     * @param user
     * @return
     */
    public static String getToken(User user){
        String token = null;
        try {
            Date expireAt = new Date(System.currentTimeMillis() + SURVIVAL_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("username",user.getUsername())
                    .withExpiresAt(expireAt)
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        }catch (IllegalArgumentException| JWTCreationException je){
            je.printStackTrace();
        }
        return token;
    }

    public static Boolean verify(String token){
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            System.out.println("验证通过：");
            System.out.println("username:"+ decodedJWT.getClaim("username").asString());
            System.out.println("过期时间：" + decodedJWT.getExpiresAt());
        }catch (IllegalArgumentException | JWTVerificationException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
