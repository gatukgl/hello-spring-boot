package com.example.springbootonline2.controller;

import com.example.springbootonline2.domain.Employee;
import com.example.springbootonline2.repository.EmployeeRepository;
import com.example.springbootonline2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Employee> listAllEmployee() {
        return employeeService.listAll();
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
       return employeeService.findById(id);
    }

    // @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public void  createEmployee(@RequestBody Employee employee) {
       employeeService.save(employee);
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        employeeService.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.delete(id);
    }
}
