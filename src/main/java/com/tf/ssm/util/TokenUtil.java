package com.tf.ssm.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.util.Base64Utils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenUtil {
    //设置30分钟过期
    private static final long EXPIRE_DATE = 30*60*1000;
    //Token密匙
    private static final String TOKEN_SECRET = "EQIUBFKSJBFJH2367816BQWE";
    private static final String JWT_ID = UUID.randomUUID().toString();

    public SecretKey generalKey(){
        String stringKey = TOKEN_SECRET;

        byte[] encodeKey = Base64Utils.decodeFromString(stringKey);

        SecretKey key = new SecretKeySpec(encodeKey,0,encodeKey.length,"AES");
        return key;
    }

    /**
     * @return 返回一个token
     */
    public static String getToken(String username,int uid){
        String token = "";

        try{
            String id = String.valueOf(uid);
            //设置过期时间
            Date date = new Date(System.currentTimeMillis()+EXPIRE_DATE);
            //秘匙及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");

            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username",username)
                    .withClaim("uid",id)
                    .withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return token;
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static boolean verify(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        String token = TokenUtil.getToken("root",1);
        System.out.println(token);
    }
}
