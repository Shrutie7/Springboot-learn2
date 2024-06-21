package com.shruticodes.tutorial.controllers;


import com.shruticodes.tutorial.dto.EmployeeDTO;
import com.shruticodes.tutorial.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


//    @GetMapping(path="/{id}")
//    public EmployeeDTO getEmployee(@PathVariable("id") Long employeeId){
//        return new EmployeeDTO(employeeId,"shruti",LocalDate.of(2024,1,2),true);
//    }

    @GetMapping(path="/get")
    public String getEmployee(@PathParam("sortBy") String sortBy,@PathParam("limit") Integer limit){

        return "Hello " + sortBy + " " + limit;
    }
    @GetMapping(path="/{id}")
    public EmployeeDTO getEmployeeService(@PathVariable("id") Long employeeId){
        return employeeService.getEmployeeService(employeeId);
    }
    @GetMapping(path="/all")
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @PostMapping(path="/create")
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.createNewEmployee(employeeDTO);

    }
    @DeleteMapping(path="/delete/{id}")
    public boolean deleteEmployeeById(@PathVariable long id){
        return employeeService.deleteEmployeeById(id);
    }

}
