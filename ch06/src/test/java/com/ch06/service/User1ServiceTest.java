package com.ch06.service;

import com.ch06.dto.User1DTO;
import jdk.jfr.Name;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class User1ServiceTest {

    @Autowired
    private User1Service user1Service;

    @Order(1)
    @Name("insert")
    @Test
    void insertUser1() {
        // 테스트 정의 : given - when - then 패턴

        // given : 테스트를 실행하기 위한 준비단계
        User1DTO sample = User1DTO.builder()
                .uid("a202")
                .name("김유신")
                .birth("1999-01-02")
                .hp("010-2222-1010")
                .age(22)
                .build();

        // when : 테스트를 진행하는 단계
        user1Service.insertUser1(sample);

        // then : 테스트 결과를 검증하는 단계, Assert 단정문을 이용해 결과 출력
        User1DTO expected = user1Service.selectUser1(sample.getUid());
        Assertions.assertEquals(expected.toString(), sample.toString());

    }

    @Order(2)
    @Name("select1")
    @Test
    void selectUser1() {
        // given
        String uid = "a202";

        // when
        User1DTO expected = user1Service.selectUser1(uid);

        // then
        Assertions.assertEquals(expected.getUid(), uid);
    }

    @Order(3)
    @Name("select2")
    @Test
    void selectUser1s() {

        List<User1DTO> expected = user1Service.selectUser1s();

//        Assertions.assertFalse(expected.isEmpty()); // 테스트 통과
        Assertions.assertNotNull(expected);
    }

    @Order(4)
    @Name("update")
    @Test
    void updateUser1() {
        User1DTO sample = User1DTO.builder()
                .uid("a202")
                .name("김유진")
                .birth("1999-01-22")
                .hp("010-2222-2222")
                .age(22)
                .build();

        user1Service.updateUser1(sample);

        User1DTO expected = user1Service.selectUser1(sample.getUid());
        Assertions.assertEquals(expected.toString(), sample.toString());

    }

    @Order(5)
    @Name("delete")
    @Test
    void deleteUser1() {
        String uid = "a202";
        user1Service.deleteUser1(uid);

        User1DTO expected = user1Service.selectUser1(uid);
        assertNull(expected);
    }
}