package com.EMS.service;

import com.EMS.entity.Employee;
import com.EMS.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {
    private final EmployeeRepository employeeRepository;

    public EmployeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee>getAllEmployee(){
        return employeeRepository.findAll();
    }
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

}
