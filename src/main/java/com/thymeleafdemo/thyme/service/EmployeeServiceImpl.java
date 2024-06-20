package com.thymeleafdemo.thyme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thymeleafdemo.thyme.dao.EmployeeRepository;
import com.thymeleafdemo.thyme.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;

	}

	@Override
	@Transactional
	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);

		Employee theEmployee = null;

		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException(" Employee not found with id  " + theId);
		}

		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeRepository.save(theEmployee);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(theId);
	}

}
