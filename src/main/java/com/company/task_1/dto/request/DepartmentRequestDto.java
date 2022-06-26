package com.company.task_1.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartmentRequestDto {
    private String name;
    private String companyId;
}
