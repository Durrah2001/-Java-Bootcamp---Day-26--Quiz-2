package org.example.exam.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {

    @NotEmpty(message = "ID cannot be empty!")
    private String ID;

    @NotEmpty(message = "Name cannot be empty!")
    private String name;

    @NotNull(message = "Number of pages cannot be empty!")
    private int number_of_pages;

    @Positive(message = "Must be a valid number!")
    private double price;

    @NotEmpty(message = "Category cannot be empty!")
    @Pattern(regexp = "^(Novel|Academic)$", message = "Category should be either novel or academic!")
    private String category;

    @NotNull(message = "Cannot be empty!")
    private boolean isAvailable;










}
