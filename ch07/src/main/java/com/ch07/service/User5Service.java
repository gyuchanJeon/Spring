package com.ch07.service;

import com.ch07.dto.User5DTO;
import com.ch07.entity.User5;
import com.ch07.repository.User5Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class User5Service {

    private final User5Repository user5Repository;

    public void insertUser5(User5DTO user5DTO) {
        User5 entity = user5DTO.toEntity();
        user5Repository.save(entity);
    }

    public User5DTO selectUser5(String seq) {
        Optional<User5> opt = user5Repository.findById(seq);
        if (opt.isPresent()) {
            return opt.get().toDTO();

        }
        return null;
    }

    public List<User5DTO> selectUser5s() {
        List<User5> user5s = user5Repository.findAll();
        List<User5DTO> users = user5s.stream().map(entity -> entity.toDTO()).collect(Collectors.toList());
        return users;
    }

    public void updateUser5(User5DTO user5DTO) {
        boolean result = user5Repository.existsById(user5DTO.getSeq());
        if (result) {
            user5Repository.save(user5DTO.toEntity());
        }
    }

    public void deleteUser5(String seq) {
        user5Repository.deleteById(seq);
    }
}
