package com.ejornal.ejornal.dto;

import com.ejornal.ejornal.model.Group;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDto {
    private Long id;
    private String name;
    private String patronymic;
    private String surname;
    private String phone;
    private String address;
    private String email;
    private String title;
    private List<GroupDto> groups;
}
