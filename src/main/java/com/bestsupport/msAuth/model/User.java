package com.bestsupport.msAuth.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private String token;
}