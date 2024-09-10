package com.ch07.entity.shop;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "shop_customer")
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private String custId;
    private String name;
    private int age;
    private String hp;
    private String addr;

    @CreationTimestamp
    private LocalDateTime rdate;



}
