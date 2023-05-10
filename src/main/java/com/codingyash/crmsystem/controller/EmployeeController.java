package com.codingyash.crmsystem.controller;

import com.codingyash.crmsystem.entity.Employee;
import com.codingyash.crmsystem.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;


    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // get the employees from db
        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employee-list";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Employee newEmployee = new Employee();
        theModel.addAttribute("employee", newEmployee);
        return "employee/show-new-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@ModelAttribute("employeeId") int theID, Model theModel) {
        Employee theEmployee = employeeService.findById(theID);
        theModel.addAttribute("employee", theEmployee);
        return "/employee/show-new-form";

    }
    @GetMapping("/delete")
    public String delete(@ModelAttribute("employeeId") int theId) {
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }

}

