package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
