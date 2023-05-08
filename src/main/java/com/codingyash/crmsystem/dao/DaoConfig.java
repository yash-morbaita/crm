package com.codingyash.crmsystem.dao;

import com.codingyash.crmsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoConfig extends JpaRepository<Employee,Integer> {
}
