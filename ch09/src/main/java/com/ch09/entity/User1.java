package com.ch09.entity;

import com.ch09.dto.User1DTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "user1")
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User1 {

    @Id
    private String uid;

    @Column
    private String name;

    @Column
    private String birth;

    @Column
    private String hp;

    @Column
    private int age;

    public User1DTO toDTO() {
        return User1DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .age(age)
                .build();
    }
}
