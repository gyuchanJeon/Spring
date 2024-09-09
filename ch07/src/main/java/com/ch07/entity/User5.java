package com.ch07.entity;

import com.ch07.dto.User5DTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user5")
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 필드(컬럼)값이 자동 1증가(auto_increment)
    private String seq;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private int age;

    @Column
    private String addr;

    public User5DTO toDTO() {
        return User5DTO.builder()
                .seq(seq)
                .name(name)
                .gender(gender)
                .age(age)
                .addr(addr)
                .build();
    }

}
