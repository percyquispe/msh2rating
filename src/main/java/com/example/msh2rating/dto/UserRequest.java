package com.example.msh2rating.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NonNull
    @NotEmpty
    private String name;

    @NonNull
    @NotEmpty
    private String email;

    @NonNull
    @NotEmpty
    private String cellPhone;
    private String department;
}