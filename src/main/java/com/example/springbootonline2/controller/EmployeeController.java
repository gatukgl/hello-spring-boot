package com.example.springbootonline2.controller;

import com.example.springbootonline2.domain.Employee;
import com.example.springbootonline2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Employee> listAllEmployee() {
        return employeeRepository.listAll();
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
       return employeeRepository.findById(id);
    }

    // @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public void  createEmployee(@RequestBody Employee employee) {
       employeeRepository.save(employee);
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Integer Id, @RequestBody Employee employee) {

    }
}
