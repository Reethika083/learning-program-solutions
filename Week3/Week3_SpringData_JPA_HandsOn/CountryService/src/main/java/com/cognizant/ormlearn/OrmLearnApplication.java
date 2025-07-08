package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.repository.*;
import com.cognizant.ormlearn.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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

        // ✅ Uncomment the one you want to test
        // testGetEmployee();
        // testAddSkillToEmployee();
        testGetAllPermanentEmployees(); // 🆕 for Ex 2
    }

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

    private static void testAddSkillToEmployee() {
        LOGGER.info("Start testAddSkillToEmployee");

        Employee employee = employeeService.get(1); // existing employee ID
        Skill skill = skillService.get(2); // skill ID to be added

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
}
