package com.ch06.service;

import com.ch06.dto.User2DTO;
import jdk.jfr.Name;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class User2ServiceTest {

    @Autowired
    private User2Service user2Service;

    @Name("insert")
    @Order(1)
    @Test
    void insertUser2() {
        User2DTO sample = User2DTO.builder()
                .uid("A107")
                .name("손오공")
                .birth("1234-05-06")
                .addr("화과산 깊은 곳")
                .build();
        user2Service.insertUser2(sample);
        User2DTO expected = user2Service.selectUser2(sample.getUid());
        assertEquals(expected.toString(), sample.toString());

    }

    @Name("select1")
    @Order(2)
    @Test
    void selectUser2() {
        String uid = "A107";
        User2DTO sample = user2Service.selectUser2(uid);
        assertEquals(sample.getUid(), uid);
    }

    @Name("select2")
    @Order(3)
    @Test
    void selectUser2s() {
        List<User2DTO> users = user2Service.selectUser2s();
        assertNotNull(users);
    }

    @Name("update")
    @Order(4)
    @Test
    void updateUser2() {
        User2DTO sample = User2DTO.builder()
                .uid("A107")
                .name("손오반")
                .birth("1234-05-08")
                .addr("화과산 정문 앞")
                .build();
        user2Service.updateUser2(sample);
        User2DTO expected = user2Service.selectUser2(sample.getUid());
        assertEquals(expected.toString(), sample.toString());

    }

    @Name("delete")
    @Order(5)
    @Test
    void deleteUser2() {
        String uid = "A107";
        user2Service.deleteUser2(uid);
        User2DTO expected = user2Service.selectUser2(uid);
        assertNull(expected);
    }
}