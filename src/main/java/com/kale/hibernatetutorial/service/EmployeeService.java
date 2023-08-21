package com.kale.hibernatetutorial.service;
import com.kale.hibernatetutorial.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    void create(Employee employee);
    void delete (int id);
    Employee update (Employee employee);
}
