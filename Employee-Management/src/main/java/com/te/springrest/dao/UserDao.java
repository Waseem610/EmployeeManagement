package com.te.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.te.springrest.model.User_Info;

@Repository
public interface UserDao extends JpaRepository<User_Info, Integer> {
	public User_Info findByUserName(String userName);
	@Query(value = "from User_Info where email=:email")
	public User_Info findByEmail(String email);

}
