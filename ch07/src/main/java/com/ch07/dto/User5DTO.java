package com.ch07.dto;

import com.ch07.entity.User5;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User5DTO {
    private String seq;
    private String name;
    private String gender ;
    private int age;
    private String addr;

    public User5 toEntity() {
        return User5.builder()
                .seq(seq)
                .name(name)
                .gender(gender)
                .age(age)
                .addr(addr)
                .build();
    }
}
