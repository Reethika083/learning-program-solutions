package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.repository.*;
import com.cognizant.ormlearn.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static StockRepository stockRepository;

    private static EmployeeRepository employeeRepository;
    private static DepartmentRepository departmentRepository;
    private static SkillRepository skillRepository;

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        countryService = context.getBean(CountryService.class);
        stockRepository = context.getBean(StockRepository.class);
        employeeRepository = context.getBean(EmployeeRepository.class);
        departmentRepository = context.getBean(DepartmentRepository.class);
        skillRepository = context.getBean(SkillRepository.class);

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);

        // ✅ Choose only the one you want to test

        // testAddEmployee();
        // testUpdateEmployee();
        testGetDepartment(); // 🆕 For Hands-on 5
    }

    private static void testAddEmployee() {
        LOGGER.info("Start testAddEmployee");

        Employee employee = new Employee();
        employee.setName("Reethika");
        employee.setSalary(70000);
        employee.setPermanent(true);
        employee.setDateOfBirth(java.sql.Date.valueOf("2002-08-04"));

        Department department = departmentService.get(1);
        employee.setDepartment(department);

        employeeService.save(employee);
        LOGGER.debug("Added Employee: {}", employee);

        LOGGER.info("End testAddEmployee");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start testUpdateEmployee");

        Employee employee = employeeService.get(1);
        Department newDept = departmentService.get(2);

        if (employee != null && newDept != null) {
            employee.setDepartment(newDept);
            employeeService.save(employee);
            LOGGER.debug("Updated Employee: {}", employee);
        } else {
            LOGGER.warn("Employee or Department not found.");
        }

        LOGGER.info("End testUpdateEmployee");
    }

    private static void testGetDepartment() {
        LOGGER.info("Start testGetDepartment");

        Department department = departmentService.get(1); // dept with multiple employees
        LOGGER.debug("Department: {}", department);
        LOGGER.debug("Employees: {}", department.getEmployeeList());

        LOGGER.info("End testGetDepartment");
    }
}
