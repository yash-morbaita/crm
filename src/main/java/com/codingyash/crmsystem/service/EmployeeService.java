package com.codingyash.crmsystem.service;

import com.codingyash.crmsystem.entity.Employee;

import java.util.List;


public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void deleteById(int theId);

}

