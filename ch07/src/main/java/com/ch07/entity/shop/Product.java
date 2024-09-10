package com.ch07.entity.shop;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "shop_product")
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prodNo;
    private String prodName;
    private int stock;
    private int price;
    private String company;


}
