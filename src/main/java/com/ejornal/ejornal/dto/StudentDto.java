package com.ejornal.ejornal.dto;

import lombok.Data;


@Data
public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String address;
    private GroupDto groupDto;
}
