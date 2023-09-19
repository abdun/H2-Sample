package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@Scope(value="prototype")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee addEmployee(@RequestBody Employee employee) {
        System.out.println(" Value of ::" + this.toString());
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> fetchEmployeeList() {
        return employeeService.fetchEmployeeList();
    }

    @PutMapping("/departments/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id) {
        return employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteEmployeetById(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "Deleted Successfully";
    }
}
