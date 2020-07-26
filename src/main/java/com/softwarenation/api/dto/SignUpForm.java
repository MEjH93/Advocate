package com.softwarenation.api.dto;

import lombok.Data;

import java.util.Set;

import javax.validation.constraints.*;
@Data
public class SignUpForm {
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank
    @Size(min = 3, max = 50)
    private String surname;


    @NotBlank
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank
    @Size(max = 60)
    @Email
    private String email;


    @NotBlank
    @Size(min = 6, max = 40)
    private String password;



}