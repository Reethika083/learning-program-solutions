package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.repository.*;
import com.cognizant.ormlearn.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeRepository employeeRepository;
    private static DepartmentRepository departmentRepository;
    private static SkillRepository skillRepository;

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        employeeRepository = context.getBean(EmployeeRepository.class);
        departmentRepository = context.getBean(DepartmentRepository.class);
        skillRepository = context.getBean(SkillRepository.class);

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        // ✅ Uncomment based on the hands-on to test
        // testGetEmployee(); // Ex 3
        // testGetDepartment(); // Ex 3, 5
        // testGetSkill(); // Ex 3
        // testAddEmployee(); // Ex 4
        // testUpdateEmployee(); // Ex 4
        // testAddSkillToEmployee(); // Ex 6
        testGetAllPermanentEmployees(); // Ex 2
    }

    // ✅ Ex 2: Find all permanent employees
    private static void testGetAllPermanentEmployees() {
        LOGGER.info("Start testGetAllPermanentEmployees");

        List<Employee> permanentEmployees = employeeService.getAllPermanentEmployees();
        permanentEmployees.forEach(emp -> {
            LOGGER.debug("Employee: {}", emp);
            LOGGER.debug("Department: {}", emp.getDepartment());
            LOGGER.debug("Skills: {}", emp.getSkillList());
        });

        LOGGER.info("End testGetAllPermanentEmployees");
    }

    // ✅ Ex 3: Get employee by ID with dept and skills
    private static void testGetEmployee() {
        LOGGER.info("Start testGetEmployee");

        employeeRepository.findById(1).ifPresentOrElse(emp -> {
            LOGGER.debug("Employee: {}", emp);
            LOGGER.debug("Department: {}", emp.getDepartment());
            LOGGER.debug("Skills: {}", emp.getSkillList());
        }, () -> {
            LOGGER.warn("Employee with ID 1 not found.");
        });

        LOGGER.info("End testGetEmployee");
    }

    // ✅ Ex 3 & 5: Get department and all employees
    private static void testGetDepartment() {
        LOGGER.info("Start testGetDepartment");

        Department department = departmentService.get(1); // Use existing dept ID
        LOGGER.debug("Department: {}", department);
        LOGGER.debug("Employees: {}", department.getEmployeeList());

        LOGGER.info("End testGetDepartment");
    }

    // ✅ Ex 3: Get skill and all employees with it
    private static void testGetSkill() {
        LOGGER.info("Start testGetSkill");

        skillRepository.findById(1).ifPresentOrElse(skill -> {
            LOGGER.debug("Skill: {}", skill);
            LOGGER.debug("Employees with skill: {}", skill.getEmployeeList());
        }, () -> {
            LOGGER.warn("Skill with ID 1 not found.");
        });

        LOGGER.info("End testGetSkill");
    }

    // ✅ Ex 4: Add new employee with department
    private static void testAddEmployee() {
        LOGGER.info("Start testAddEmployee");

        Employee employee = new Employee();
        employee.setName("Reethika");
        employee.setSalary(70000);
        employee.setPermanent(true);
        employee.setDateOfBirth(Date.valueOf("2002-08-04"));

        Department department = departmentService.get(1);
        employee.setDepartment(department);

        employeeService.save(employee);
        LOGGER.debug("Added Employee: {}", employee);

        LOGGER.info("End testAddEmployee");
    }

    // ✅ Ex 4: Update department of existing employee
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

    // ✅ Ex 6: Add skill to an employee
    private static void testAddSkillToEmployee() {
        LOGGER.info("Start testAddSkillToEmployee");

        Employee employee = employeeService.get(1); // Existing employee
        Skill skill = skillService.get(2); // Skill to be added

        if (employee != null && skill != null) {
            Set<Skill> skills = employee.getSkillList();
            skills.add(skill);
            employee.setSkillList(skills);
            employeeService.save(employee);

            LOGGER.debug("Updated Employee with Skills: {}", employee.getSkillList());
        } else {
            LOGGER.warn("Employee or Skill not found.");
        }

        LOGGER.info("End testAddSkillToEmployee");
    }
}
