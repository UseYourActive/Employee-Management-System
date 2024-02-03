package com.ems.employee_service.persistence.entities.ideas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.Month;

@Entity
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private Month month;
    private int year;
    private BigDecimal basicSalary;
    private BigDecimal deductions;
    private BigDecimal bonuses;
    private BigDecimal netSalary;

    // Getters and setters
}

//    public Payroll generatePayroll(Long employeeId, Month month, int year, BigDecimal basicSalary, BigDecimal deductions, BigDecimal bonuses) {
//        Payroll payroll = new Payroll();
//        payroll.setEmployeeId(employeeId);
//        payroll.setMonth(month);
//        payroll.setYear(year);
//        payroll.setBasicSalary(basicSalary);
//        payroll.setDeductions(deductions);
//        payroll.setBonuses(bonuses);
//
//        // Calculate net salary
//        BigDecimal netSalary = basicSalary.subtract(deductions).add(bonuses);
//        payroll.setNetSalary(netSalary);
//
//        return payrollRepository.save(payroll);
//    }