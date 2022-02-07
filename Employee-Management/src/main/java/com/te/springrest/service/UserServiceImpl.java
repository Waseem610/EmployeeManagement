package com.te.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.te.springrest.dao.UserDao;
import com.te.springrest.model.User_Info;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao dao;

	@Override
	public User_Info register(User_Info info) {
		if (info == null) {
			return null;
		}
		try {
			return dao.save(info);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public User_Info login(String userName, String password) {
		try {
			User_Info findByUserName = dao.findByUserName(userName);
			if (findByUserName.getUserName().equals(userName) && findByUserName.getPassword().equals(password)) {
				return findByUserName;
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public User_Info forgotPassword(String email, String password) {
		try {
			User_Info findByEmail = dao.findByEmail(email);
			findByEmail.setPassword(password);
			return findByEmail;
		} catch (Exception e) {
			return null;
		}
		
		

	}
}
