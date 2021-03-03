package com.example.test.controller;

import com.example.test.exception.ResourceNotFoundException;
import com.example.test.model.Employee;
import com.example.test.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    // get employees
    @GetMapping("/employees")
    public List<Employee> getALLEmployee(){
        return this.employeeRepository.findAll();
    }
    // get employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }
    // save employee
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return this.employeeRepository.save(employee);

    }
    // update employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
       @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        employee.setEmail(employeeDetails.getEmail());
        employee.setFristName(employeeDetails.getFristName());
        employee.setLaastName(employeeDetails.getLastName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(this.employeeRepository.save(employee));
    }

    // delete employee
    @DeleteMapping("/employees/{id}")
    public Map<String , Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId ,

                                                @Valid @RequestBody Employee employeeDetails)                                         throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        this.employeeRepository.delete(employee);
        Map<String , Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;

    }




}
