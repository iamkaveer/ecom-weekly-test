package com.ecomapi.ecomAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_order")
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "userId")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "productId")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "addressId")
    private Address address;

    private Integer productQuantity;

}
