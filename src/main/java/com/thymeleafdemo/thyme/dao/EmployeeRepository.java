package com.thymeleafdemo.thyme.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thymeleafdemo.thyme.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
