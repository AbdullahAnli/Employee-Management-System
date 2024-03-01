package com.EMS.controller;

import com.EMS.entity.Employee;
import com.EMS.repository.EmployeeRepository;
import com.EMS.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeService employeService;
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeService employeService){
        this.employeService=employeService;
    }
    @GetMapping
    public List<Employee>getAllemployee(){
        return employeService.getAllEmployee();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("not found employee"+id));
    }
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee createEmployee= employeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createEmployee);
    }
    @DeleteMapping()
    public void deleteEmployee(@PathVariable Long id){
        employeeRepository.deleteById(id);
    }
    //put map
    @PutMapping()
        public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
        Employee employee =employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("employee not found"+id));
        employee.setName(employeeDetails.getName());
        employee.setSurname(employeeDetails.getSurname());
        employee.setWage(employeeDetails.getWage());

        return employeeRepository.save(employee);
        }


}
