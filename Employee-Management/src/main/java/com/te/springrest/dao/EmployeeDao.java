package com.te.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.springrest.model.Employee_Info;
@Repository
public interface EmployeeDao extends JpaRepository<Employee_Info, Integer>{

}
