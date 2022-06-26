package com.company.task_1.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkerResponseDto {
    private String id;
    private LocalDateTime createdDate;
    private String name;
    private String phoneNumber;
    private String addressId;
    private String departmentId;
}
