package com.te.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.te.springrest.model.EmployeeResponse;
import com.te.springrest.model.EmployeeResponseList;
import com.te.springrest.model.Employee_Info;
import com.te.springrest.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {
	@Autowired
	EmployeeServiceImpl service;

	@PostMapping("add")
	public ResponseEntity<EmployeeResponse> add(@RequestBody Employee_Info info) {
		Employee_Info add = service.add(info);
		EmployeeResponse employeeResponse = new EmployeeResponse(false, add);
		return new ResponseEntity<EmployeeResponse>(employeeResponse, HttpStatus.OK);
	}

	@PutMapping("edit")
	public ResponseEntity<EmployeeResponse> edit(@RequestBody Employee_Info info) {
		Employee_Info edit = service.add(info);
		EmployeeResponse employeeResponse = new EmployeeResponse(false, edit);
		return new ResponseEntity<EmployeeResponse>(employeeResponse, HttpStatus.OK);
	}

	@DeleteMapping("delete")
	public ResponseEntity<EmployeeResponse> delete(@RequestBody Employee_Info info) {
		Employee_Info delete = service.delete(info);
		EmployeeResponse employeeResponse = new EmployeeResponse(false, delete);
		return new ResponseEntity<EmployeeResponse>(employeeResponse, HttpStatus.OK);
	}

	@PostMapping("All")
	public ResponseEntity<EmployeeResponseList> display() {
		List<Employee_Info> display = service.Display();
		EmployeeResponseList employeeResponseList = new EmployeeResponseList();
		employeeResponseList.setError(false);
		employeeResponseList.setData(display);
		return new ResponseEntity<EmployeeResponseList>(employeeResponseList, HttpStatus.OK);
	}
}
