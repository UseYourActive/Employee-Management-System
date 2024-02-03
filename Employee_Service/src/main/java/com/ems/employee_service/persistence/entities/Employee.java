package com.ems.employee_service.persistence.entities;

import com.ems.employee_service.persistence.enums.Department;
import com.ems.employee_service.persistence.enums.Designation;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.UUID;

@Entity
@Table(name = "employees")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "unique_civil_number", nullable = false, unique = true)
    private String uniqueCivilNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "designation", nullable = false)
    private Designation designation;

    @Enumerated(EnumType.STRING)
    @Column(name = "department", nullable = false)
    private Department department;

    @Embedded
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    @AttributeOverrides({
            @AttributeOverride(name = "email", column = @Column(name = "email")),
            @AttributeOverride(name = "phoneNumber", column = @Column(name = "phone_number"))
    })
    private ContactInformation contactInformation;

    @Embedded
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "amount")),
            @AttributeOverride(name = "effectiveDate", column = @Column(name = "effective_date"))
    })
    private Salary salary;

    @Embedded
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    @AttributeOverrides({
            @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
            @AttributeOverride(name = "lastModifiedAt", column = @Column(name = "last_modified_at"))
    })
    private Creation creation;

    @Embedded
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    @AttributeOverrides({
            @AttributeOverride(name = "dateOfBirth", column = @Column(name = "date_of_birth")),
            @AttributeOverride(name = "gender", column = @Column(name = "gender")),
            @AttributeOverride(name = "address", column = @Column(name = "address")),
            @AttributeOverride(name = "maritalStatus", column = @Column(name = "marital_status"))
    })
    private EmployeeDetails employeeDetails;
}
