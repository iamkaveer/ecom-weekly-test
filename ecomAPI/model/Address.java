package com.ecomapi.ecomAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String street;
    private String landmark;
    private String phoneNumber;
    private String zipcode;
    private String state;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_user_id")
//    private User user;
}
