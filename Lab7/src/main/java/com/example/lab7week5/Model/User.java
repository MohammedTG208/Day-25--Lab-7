package com.example.lab7week5.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotNull(message = "the id Can not be null")
    @Positive(message = "the is most be positive")
    private int id;
    @NotEmpty(message = "The name requirement")
    @Size(min = 4,message = "the name most be 4 char")
    @Pattern(regexp = "^[a-zA-Z]+$",message = "Only Text with out any number or sign")
    private String name;
    @NotEmpty(message = "Enter your number")
    @Pattern(regexp = "^05\\d*$",message = "The number like this 05XXXXXXXX")
    @Size(max = 10,message = "the number most contain 10 diget")
    private String phone_number;
    @Email(message = "Enter valid email")
    private String email;
    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$",message = "contains at least eight characters,\n" +
            "including at least one number and\n" +
            "includes both lower and uppercase letters and\n" +
            "include at least one special characters, #, ?, !.")
    private String password;
    @AssertFalse(message = "most be false")
    private boolean isSubscribe;

}
