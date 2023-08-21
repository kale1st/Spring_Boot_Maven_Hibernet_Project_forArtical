package com.kale.hibernatetutorial.dao;

import com.kale.hibernatetutorial.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
    Employee findById(int id);
    void create(Employee employee);
    void delete (int id);
    Employee update(Employee employee);
}
