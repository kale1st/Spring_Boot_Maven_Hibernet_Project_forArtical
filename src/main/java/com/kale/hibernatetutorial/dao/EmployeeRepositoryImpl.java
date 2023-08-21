package com.kale.hibernatetutorial.dao;

import com.kale.hibernatetutorial.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("from Employee",Employee.class).getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public void create(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.getReference(Employee.class,id));
    }

    @Override
    public Employee update(Employee employee) {
        return entityManager.merge(employee);
    }
}
