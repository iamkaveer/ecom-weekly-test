package com.ecomapi.ecomAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomapi.ecomAPI.model.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from tbl_user where user_id =:userId",nativeQuery = true)
    User getUserById(Integer userId);
}
