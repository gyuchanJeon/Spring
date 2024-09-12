package com.ch10.jwt;

import com.ch10.entity.User;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtProviderTest {

    @Autowired
    private JwtProvider jwtProvider;

    @Test
    void createToken() {

        User user = User.builder()
                .uid("a101")
                .name("김유신")
                .birth("1990-09-09")
                .role("ADMIN")
                .build();
        String jwt = jwtProvider.createToken(user, 1);
        System.out.println(jwt);
    }

    @Test
    void getClaims() {

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJpYW44MTA5MDBAZ21haWwuY29tIiwiaWF0IjoxNzI2MTIzNzE5LCJleHAiOjE3MjYyMTAxMTksInVzZXJuYW1lIjoiYTEwMSIsInJvbGUiOiJBRE1JTiJ9.4AlnUAeteLkUYfViq1xQti-JpDXX2mbPd331Q2fX9Ck\n";

        Claims claims = jwtProvider.getClaims(token);
        String username = (String) claims.get("username");
        String role = (String) claims.get("role");

        System.out.println(username + ", " + role);
    }

    @Test
    void getAuthentication() {
    }

    @Test
    void validateToken() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJpYW44MTA5MDBAZ21haWwuY29tIiwiaWF0IjoxNzI2MTIzNzE5LCJleHAiOjE3MjYxMjM3MTksInVzZXJuYW1lIjoiYTEwMSIsInJvbGUiOiJBRE1JTiJ9.y8GDsEpT5Fct8s8kZ9_llbqtrUk4C4kL5D0P8eESjQM";

        try {
            jwtProvider.validateToken(token);
            System.out.println("토큰 이상 없음");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getIssuer() {
    }

    @Test
    void getSecretKey() {
    }
}