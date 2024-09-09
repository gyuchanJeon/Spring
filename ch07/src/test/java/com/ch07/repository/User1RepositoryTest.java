package com.ch07.repository;

import com.ch07.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;

    @Test
    void findUser1ByUid() {
        User1 entity = user1Repository.findUser1ByUid("a101");
        System.out.println(entity);
    }

    @Test
    void findUser1ByName() {
        List<User1> users = user1Repository.findUser1ByName("김유신");
        System.out.println(users);
    }

    @Test
    void findUser1ByNameNot() {
        List<User1> users = user1Repository.findUser1ByNameNot("김유신");
        System.out.println(users);
    }

    @Test
    void findUser1ByUidAndName() {
        User1 entity = user1Repository.findUser1ByUidAndName("a101", "김유신");
        System.out.println(entity);
    }

    @Test
    void findUser1ByUidOrName() {
        List<User1> entity = user1Repository.findUser1ByUidOrName("a101", "김춘추");
        System.out.println(entity);
    }

    @Test
    void findUser1ByAgeGreaterThan() {
        List<User1> entity = user1Repository.findUser1ByAgeGreaterThan(50);
        System.out.println(entity);
    }

    @Test
    void findUser1ByAgeGreaterThanEqual() {
        List<User1> entity = user1Repository.findUser1ByAgeGreaterThanEqual(50);
        System.out.println(entity);
    }

    @Test
    void findUser1ByAgeLessThan() {
        List<User1> entity = user1Repository.findUser1ByAgeLessThan(56);
        System.out.println(entity);
    }

    @Test
    void findUser1ByAgeLessThanEqual() {
        List<User1> entity = user1Repository.findUser1ByAgeLessThanEqual(56);
        System.out.println(entity);
    }

    @Test
    void findUser1ByAgeBetween() {
        List<User1> entity = user1Repository.findUser1ByAgeBetween(56, 81);
        System.out.println(entity);
    }

    @Test
    void findUser1ByNameLike() {
    }

    @Test
    void findUser1ByNameContains() {
    }

    @Test
    void findUser1ByNameStartsWith() {
    }

    @Test
    void findUser1ByNameEndsWith() {
    }

    @Test
    void findUser1ByOrderByName() {
    }

    @Test
    void findUser1ByOrderByAgeAsc() {
    }

    @Test
    void findUser1ByOrderByAgeDesc() {
    }

    @Test
    void findUser1ByAgeGreaterThanOrderByAgeDesc() {
    }

    @Test
    void countUser1ByUid() {
    }

    @Test
    void countUser1ByName() {
    }

    @Test
    void selectUser1UnderAge30() {
    }

    @Test
    void selectUser1WhereName() {
    }

    @Test
    void selectUser1WhereNameParam() {
    }

    @Test
    void selectFromParentJoinChild() {
        List<Object[]> list = user1Repository.selectFromParentJoinChild("P101");

        for (Object[] obj : list) {
            String obj0 = obj[0].toString();
            String obj1 = obj[1].toString();

            System.out.println(obj0);
            System.out.println(obj1);
        }
    }
}