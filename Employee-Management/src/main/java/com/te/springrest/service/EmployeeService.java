package com.te.springrest.service;

import java.util.List;

import com.te.springrest.model.Employee_Info;

public interface EmployeeService {
	public Employee_Info add(Employee_Info info);
	public Employee_Info delete(Employee_Info info);
	public List<Employee_Info> Display();
}
