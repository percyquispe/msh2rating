package com.example.msh2rating.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialversionUID = 129348938L;
    private String id;
    private String name;
    private String email;
    private String cellPhone;
    private String department;
}
