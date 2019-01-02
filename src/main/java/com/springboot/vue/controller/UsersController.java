package com.springboot.vue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.vue.pojo.Users;
import com.springboot.vue.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/findUsers")
	public List<Users> findUsers() {
		List<Users> findUser = null;
		try {
			findUser = userService.findUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findUser;
	}
	
	@RequestMapping("/findUserByUid")
	public Users findUserByUid(int uid) {
		Users user = null;
		try {
			user = userService.findUserByUid(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@RequestMapping("/updateUser")
	public boolean updateUser(@RequestBody Users users) {
		try {
			if(userService.updateUser(users) == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@RequestMapping("/deleteUser")
	public boolean deleteUser(int uid) {
		try {
			if(userService.deleteUser(uid) == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@RequestMapping("/insertUser")
	public Users insertUser(@RequestBody Users users) {
		try {
			userService.insertUser(users);
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
