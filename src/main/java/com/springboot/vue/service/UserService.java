package com.springboot.vue.service;

import java.util.List;

import com.springboot.vue.pojo.Users;

public interface UserService {

	Users findUserByUid(int uid);
	
	List<Users> findUser();
	
	int updateUser(Users users);
	
	int deleteUser(int uid);
	
	void insertUser(Users users);
}
