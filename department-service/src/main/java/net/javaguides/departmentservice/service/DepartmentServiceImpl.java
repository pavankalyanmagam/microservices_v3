package net.javaguides.departmentservice.service;

import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.model.DepartmentDto;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{


    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // convert department dto to department jpa entity

        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto dto = new DepartmentDto();
        dto.setId(savedDepartment.getId());
        dto.setDepartmentDescription(savedDepartment.getDepartmentDescription());
        dto.setDepartmentName(savedDepartment.getDepartmentName());
        dto.setDepartmentCode(savedDepartment.getDepartmentCode());

        return dto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department  department = departmentRepository.findDepartmentByDepartmentCode(code);
        DepartmentDto dto = new DepartmentDto(department.getId(), department.getDepartmentName(), department.getDepartmentDescription(),department.getDepartmentCode());

        return dto;
    }


}
