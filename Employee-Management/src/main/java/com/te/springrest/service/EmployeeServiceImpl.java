package com.te.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.te.springrest.dao.EmployeeDao;
import com.te.springrest.model.Employee_Info;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao dao;

	@Override
	public Employee_Info add(Employee_Info info) {
		return dao.save(info);
	}

	@Override
	public Employee_Info delete(Employee_Info info) {
		dao.deleteById(info.getId());
		return info;
	}

	@Override
	public List<Employee_Info> Display() {
		return  dao.findAll();
	}
}
