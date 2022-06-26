package com.company.task_1.service;

import com.company.task_1.dto.request.DepartmentRequestDto;
import com.company.task_1.dto.response.DepartmentResponseDto;
import com.company.task_1.dto.response.DepartmentResponseDto;
import com.company.task_1.entity.DepartmentEntity;
import com.company.task_1.entity.DepartmentEntity;
import com.company.task_1.exp.ItemNotFoundException;
import com.company.task_1.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private DepartmentRepository repository;

    public DepartmentResponseDto create(DepartmentRequestDto dto) {
        DepartmentEntity entity = new DepartmentEntity();
        entity.setName(dto.getName());
        entity.setCompany(dto.getCompany());
        repository.save(entity);
        return toResponseDTO(entity);
    }

    private DepartmentResponseDto toResponseDTO(DepartmentEntity entity) {
        DepartmentResponseDto dto = new DepartmentResponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCompany(entity.getCompany());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public DepartmentResponseDto getById(String id) {
        DepartmentEntity entity = repository.findById(id).orElseThrow(() -> {
            throw new ItemNotFoundException("Item not Found");
        });
        return toResponseDTO(entity);
    }

    public Boolean update(DepartmentRequestDto dto, String id) {
        int n = repository.update(id, dto.getName(), dto.getCompany());
        return n > 0;
    }

    public Boolean delete(String id) {
        int n = repository.changeVisible(id, false);
        return n > 0;
    }

    public List<DepartmentEntity> getAll() {
        return repository.findAll();
    }
}
