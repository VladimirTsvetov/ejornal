package com.ejornal.ejornal.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class ProgramDto {
    private Long id;
    private String title;
    private GroupDto groupDto;

}
