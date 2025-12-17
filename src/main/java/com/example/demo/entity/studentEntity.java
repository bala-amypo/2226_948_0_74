package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity 
public class studentEntity{

    @Id
    @GeneratedValue(strategy = GnerationType.IDENTITY)
    private LONG id;

    @NotBlank(message="Name is not Valid")
    private String name;

    @Email(message = "Email format is not Valid")
    private String email;

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id; 
    }
    
    
    public studentEntity(Long id,String name,String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

}