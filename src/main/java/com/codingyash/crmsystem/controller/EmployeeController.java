package com.codingyash.crmsystem.controller;

import com.codingyash.crmsystem.entity.Employee;
import com.codingyash.crmsystem.service.EmployeeService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Configuration
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @GetMapping("/")
//    public String ShowHomePage() {
//        return "index";
//    }

    @GetMapping("/")
    public String ListEmployee(Model theModel) {
        List<Employee> theEmployee = employeeService.findAll();
        theModel.addAttribute("employees", theEmployee);
        return "index";
    }


}
