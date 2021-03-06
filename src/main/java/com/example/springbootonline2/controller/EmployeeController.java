package com.example.springbootonline2.controller;

import com.example.springbootonline2.domain.Employee;
import com.example.springbootonline2.response.EmployeeResponse;
import com.example.springbootonline2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Value("${uploadPath}")
    private String uploadPath;

    @GetMapping("/path")
    public String getUploadPath() {
        return this.uploadPath;
    }

    @GetMapping
    public List<Employee> listAllEmployee() {
        return employeeService.listAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
       return employeeService.findById(id);
    }

    @PostMapping
    public void  createEmployee(@RequestBody Employee employee) {
       employeeService.save(employee);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        employeeService.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.delete(id);
    }

    @GetMapping("/query")
    public List<Employee> findByLastName(@RequestParam(required = false) String lastName) {
        return employeeService.queryByLastName(lastName);
    }

    @GetMapping("/query2")
    public List<Employee> findByFirstName(@RequestParam(required = false) String firstName) {
        return employeeService.queryByFirstName(firstName);
    }

    @GetMapping("/nativeQuery")
    public List<EmployeeResponse> queryByNativeQuery() {
        return employeeService.queryByNativeQuery();
    }
}
