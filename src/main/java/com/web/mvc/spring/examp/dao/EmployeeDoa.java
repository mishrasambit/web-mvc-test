package com.web.mvc.spring.examp.dao;

import com.web.mvc.spring.examp.entity.Employee;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by sambit on 1/24/2017.
 */
@Service("employeeDoa")
public class EmployeeDoa {

    @PersistenceContext
    private EntityManager manager;

    public Employee getEmployeeById(Integer id) {
        return manager.find(Employee.class, id);
    }

    public Employee addEmployee(Employee employee) {
        manager.persist(employee);
        return employee;
    }
}
