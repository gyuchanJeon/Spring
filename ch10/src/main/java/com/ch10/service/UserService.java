package com.ch10.service;

import com.ch10.dto.UserDTO;
import com.ch10.entity.User;
import com.ch10.repository.UserReporitory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserReporitory userReporitory;
    private final PasswordEncoder passwordEncoder;

    public void insertUser(UserDTO userDTO) {
        // 회원가입
        String encoded = passwordEncoder.encode(userDTO.getPass()); // 비밀번호 암호화
        userDTO.setPass(encoded);

        User user = userDTO.toEntity();
        userReporitory.save(user);
    }

    public UserDTO selectUser(UserDTO userDTO) {
        Optional<User> optUser = userReporitory.findById(userDTO.getUid());
        if (optUser.isPresent()) {
            User user = optUser.get();
            return user.toDTO();
        }
        return null;
    }
}
