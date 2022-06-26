package com.company.task_1.service;

import com.company.task_1.dto.response.DepartmentResponseDto;
import com.company.task_1.dto.response.WorkerResponseDto;
import com.company.task_1.dto.request.WorkerRequestDto;
import com.company.task_1.entity.DepartmentEntity;
import com.company.task_1.entity.WorkerEntity;
import com.company.task_1.exp.ItemNotFoundException;
import com.company.task_1.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerService {
    private WorkerRepository repository;

    public WorkerResponseDto create(WorkerRequestDto dto) {
        WorkerEntity entity = new WorkerEntity();
        entity.setAddress(dto.getAddress());
        entity.setDepartmentId(dto.getDepartmentId());
        entity.setName(dto.getName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        repository.save(entity);
        return toResponseDTO(entity);
    }

    private WorkerResponseDto toResponseDTO(WorkerEntity entity) {
        DepartmentEntity department = entity.getDepartment();

        WorkerResponseDto dto = new WorkerResponseDto();
        dto.setId(entity.getId());
        dto.setAddress(entity.getAddress());
        dto.setDepartment(new DepartmentResponseDto(
                department.getId(),
                department.getCreatedDate(),
                department.getName(),
                department.getCompany()));
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public WorkerResponseDto getById(String id) {
        WorkerEntity entity = repository.findById(id).orElseThrow(() -> {
            throw new ItemNotFoundException("Item not Found");
        });
        return toResponseDTO(entity);
    }

    public Boolean update(WorkerRequestDto dto, String id) {
        int n = repository.update(id, dto.getName(), dto.getAddress(), dto.getDepartmentId(), dto.getPhoneNumber());
        return n > 0;
    }

    public Boolean delete(String id) {
        int n = repository.changeVisible(id, false);
        return n > 0;
    }

    public List<WorkerEntity> getAll() {
        return repository.findAll();
    }
}