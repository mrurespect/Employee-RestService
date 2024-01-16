package com.example.employeeapp.dao;


import com.example.employeeapp.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
}
