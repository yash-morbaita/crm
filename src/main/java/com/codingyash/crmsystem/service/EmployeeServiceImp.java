package com.codingyash.crmsystem.service;

import com.codingyash.crmsystem.dao.DaoConfig;
import com.codingyash.crmsystem.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{

    private DaoConfig daoConfig;

    public EmployeeServiceImp(DaoConfig daoConfig) {
        this.daoConfig = daoConfig;
    }

    @Override
    public List<Employee> findAll() {
        return daoConfig.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = daoConfig.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        daoConfig.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        daoConfig.deleteById(theId);
    }
}
