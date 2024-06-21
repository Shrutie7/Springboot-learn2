package com.shruticodes.tutorial.services;


import com.shruticodes.tutorial.dto.EmployeeDTO;
import com.shruticodes.tutorial.entities.EmployeeEntity;
import com.shruticodes.tutorial.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    //instead of autowired to do dependency injection use constructor injection
    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        //instead of converting dto to entity and entity to dto directly use Model Mapper

        //convert dto to entity
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO,EmployeeEntity.class);
        //save in repository
        return (modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class));

    }
    public EmployeeDTO getEmployeeService(Long id) {

        //convert entity to dto using modelmapper
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
        return modelMapper.map(employeeEntity,EmployeeDTO.class);

    }

    public List<EmployeeDTO> getAllEmployees() {
    //    return employeeRepository.findAll().stream().map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class)).collect(Collectors.toList());

        List<EmployeeDTO> li = new ArrayList<>();
        for(EmployeeEntity employeeEntity : employeeRepository.findAll()){
            EmployeeDTO map = modelMapper.map(employeeEntity,EmployeeDTO.class);//json result
            li.add(map);
        }
        return li;

    }

    public boolean deleteEmployeeById(long id) {
        boolean isPresent = employeeRepository.existsById(id);
        if(!isPresent)
            return false;
        employeeRepository.deleteById(id);
        return true;

        //better to return responseEntity
    }
}
