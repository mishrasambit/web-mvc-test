package com.web.mvc.spring.examp.service;

import com.web.mvc.spring.examp.dao.EmployeeDoa;
import com.web.mvc.spring.examp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by sambit on 1/24/2017.
 */
@Service("employeeService")
public class EmployeeService {

    @Autowired
    @Qualifier("employeeDao")
    EmployeeDoa employeeDao;

    public Employee getEmployeeById(String id) {
        return employeeDao.getEmployeeById(Integer.parseInt(id));
    }

    public Employee addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }
}
