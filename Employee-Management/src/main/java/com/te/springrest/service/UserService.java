package com.te.springrest.service;

import com.te.springrest.model.User_Info;

public interface UserService {
	public  User_Info register(User_Info info);
	public User_Info login(String userName, String password);
	public User_Info forgotPassword(String email, String password);
}
