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
        List<Employee> theEmployee = daoConfig.findAll();
        return theEmployee;
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = daoConfig.findById(theId);
        Employee theEmployee = null;
        if(result.isPresent())
        {
           theEmployee = result.get();
           return theEmployee;
        }
        else {
            throw new RuntimeException("We could find the Student" + theId);
        }
    }

    @Override
    public void saveEmployee(Employee theEmployee) {
        daoConfig.save(theEmployee);

    }

    @Override
    public void deleteById(int theId) {
        Employee theEmployee = findById(theId);
        daoConfig.deleteById(theId);
    }
}
