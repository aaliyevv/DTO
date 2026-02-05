package com.ltc.dto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequestDTO {

    @Size(min = 3, max = 10)
    private String courseName;

    @Size(min = 3, max = 10)
    private String courseCode;

    @NotNull(message = "Must be")
    private String studentName;

    @NotBlank (message = "Must not be empty")
    private String studentSurname;

}
