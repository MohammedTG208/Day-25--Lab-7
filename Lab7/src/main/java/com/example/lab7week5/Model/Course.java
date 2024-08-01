package com.example.lab7week5.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Course {
    @Positive(message = "Enter number")
    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @AssertFalse(message = "most be false")
    private boolean isAvailable;
    @NotEmpty(message = "course Name is requirement")
    @Size(min = 5,message = "the min char is 4")
    private String courseName;
    @Pattern(regexp = "^[a-zA-Z]+$",message = "Enter only string")
    private String Teacher;

}
