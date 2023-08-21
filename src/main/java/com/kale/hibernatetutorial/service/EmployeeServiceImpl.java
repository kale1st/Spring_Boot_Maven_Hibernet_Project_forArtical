package com.kale.hibernatetutorial.service;

import com.kale.hibernatetutorial.dao.EmployeeRepository;
import com.kale.hibernatetutorial.exception.EmployeeNotFoundException;
import com.kale.hibernatetutorial.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Employee findById(int id) throws EmployeeNotFoundException {
        Employee employee =  employeeRepository.findById(id);
        if(employee == null){
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        return employee;
    }

    @Override
    @Transactional
    public void create(Employee employee) {
        employeeRepository.create(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeRepository.delete(id);
    }

    @Override
    @Transactional
    public Employee update(Employee employee) {
        return employeeRepository.update(employee);
    }
}
