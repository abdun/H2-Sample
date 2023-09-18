package com.example.service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@RequiredArgsConstructor
@Service
public class EmployeeserviceImpl implements EmployeeService{

   private final EmployeeRepository employeeRepository;

     @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchEmployeeList() {

         return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee employeeDb = employeeRepository.findById(id).get();
        if (employeeDb == null ) {
            return null;
        }
        employeeDb.setName(employee.getName());
        employeeDb.setAddress(employee.getAddress());
        employeeDb.setCity(employee.getCity());
        employeeDb.setState(employee.getState());
        employeeDb.setZipcode(employee.getZipcode());
        return employeeRepository.save(employeeDb);
    }

    @Override
    public void deleteEmployeeById(Long departmentId) {

         employeeRepository.deleteById(departmentId);
    }
}
