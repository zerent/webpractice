package com.zerent.webpra.model.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserInfo {
    @NotNull
    private Long id;
    @Size(min = 2,max = 5,message = "name le3ngth invalid")
    private String name;
    @Email(message = "invalid email")
    private String email;
}
