package com.example.employeeapp.dao;


import com.example.employeeapp.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
}
