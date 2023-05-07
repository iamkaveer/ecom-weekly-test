package com.ecomapi.ecomAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomapi.ecomAPI.model.Address;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query(value = "select * from tbl_address where address_id =:addressId",nativeQuery = true)
    Address getAddressById(Integer addressId);
}
