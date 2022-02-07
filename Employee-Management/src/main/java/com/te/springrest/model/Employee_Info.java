package com.te.springrest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee_Info {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String FullName;
	private String designation;
	private double salary;
	private int age;
}
