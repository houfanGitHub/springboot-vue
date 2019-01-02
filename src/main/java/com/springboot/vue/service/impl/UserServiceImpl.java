package com.springboot.vue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.vue.mapper.UsersMapper;
import com.springboot.vue.pojo.Users;
import com.springboot.vue.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public Users findUserByUid(int uid) {
		return usersMapper.findUserByUid(uid);
	}

	@Override
	public List<Users> findUser() {
		return usersMapper.findUser();
	}

	@Override
	public int updateUser(Users users) {
		return usersMapper.updateUser(users);
	}

	@Override
	public int deleteUser(int uid) {
		return usersMapper.deleteUser(uid);
	}

	@Override
	public void insertUser(Users users) {
		usersMapper.insertUser(users);
	}

}
