package org.example.exam.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {


    @NotEmpty(message = "ID cannot be empty!")
    private String ID;

    @NotEmpty(message = "Name cannot be empty!")
    private String name;

    private int age;

    @Positive(message = "Balance should be a valid number!")
    private double balance;

    @NotEmpty(message = "Role cannot be empty!")
    @Pattern(regexp = "^(Customer|Libraian)$", message = "Role must be either customer or libraian.")
    private String role;








}
