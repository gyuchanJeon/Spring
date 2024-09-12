package com.ch09.controller;

import com.ch09.dto.User2DTO;
import com.ch09.entity.User2;
import com.ch09.service.User2Service;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor

// REST API용 컨트롤러 어노테이션
@RestController
public class User2Controller {

    private final User2Service user2Service;

    // @RestController 어노테이션을 사용하면 @ResponseBody는 생략
    @GetMapping("/user2")
    public List<User2DTO> list() {
        List<User2DTO> user2s = user2Service.selectUser2s();
        return user2s;
    }

    @GetMapping("/user2/{uid}")
    public User2DTO user(@PathVariable("uid") String uid) {
        User2DTO user2 = user2Service.selectUser2(uid);
        return user2;
    }

    @PostMapping("/user2")
    public ResponseEntity register(@RequestBody User2DTO user2DTO) {
        User2 user2 = user2Service.insertUser2(user2DTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user2);
    }

    @PutMapping("/user2")
    public ResponseEntity update(@RequestBody User2DTO user2) {
        User2 modifiedUser2 = user2Service.updateUser2(user2);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(modifiedUser2);
    }

    @DeleteMapping("/user2/{uid}")
    public ResponseEntity delete(@PathVariable("uid") String uid) {

        try {
            user2Service.deleteUser2(uid);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("success");
        }catch (EntityNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }

    }

}
