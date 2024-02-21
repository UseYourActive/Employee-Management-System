package com.ems.department_service.api.operations;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponseDTO {
    private String id;
    private String name;
    private String description;
    private String budget;
    private String location;
    private String phoneNumber;
    private String email;
}
