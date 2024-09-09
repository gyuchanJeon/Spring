package com.ch07.entity;

import com.ch07.dto.User4DTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "user4")
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User4 {

    @Id
    private String uid;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private int age;

    @Column
    private String hp;

    @Column
    private String addr;

    public User4DTO toDTO() {
        return User4DTO.builder()
                .uid(uid)
                .name(name)
                .gender(gender)
                .age(age)
                .hp(hp)
                .addr(addr)
                .build();
    }
}
