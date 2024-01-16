package com.example.employeeapp.service;

import com.example.employeeapp.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

}
