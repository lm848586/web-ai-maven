package com.llm;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class testJwt {
    @Test
    public void testJwt(){
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("id",1);
        dataMap.put("username","admin");

        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256,"bGxtamF2YXN0dWR5")
                .addClaims(dataMap)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        System.out.println(jwt);
    }

    /**
     * 解析令牌
     */
    @Test
    public void testParseJwt(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc0NTU4OTQ5Nn0.KDmAxZWwOhEnDj9vs9eTz0AH11rYYDhmZqdOXyeJPeo";
        Claims claims = Jwts.parser().setSigningKey("bGxtamF2YXN0dWR5")
                .parseClaimsJws(token)
                .getBody();
        System.out.println(claims);
    }
}
