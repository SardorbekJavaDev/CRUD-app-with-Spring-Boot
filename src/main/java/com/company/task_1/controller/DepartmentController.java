package com.company.task_1.controller;

import com.company.task_1.dto.request.DepartmentRequestDto;
import com.company.task_1.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService service;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody DepartmentRequestDto dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody DepartmentRequestDto dto, @PathVariable String id){
        return ResponseEntity.ok(service.update(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id){
        return ResponseEntity.ok(service.getById(id));
    }
}
