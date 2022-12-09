package com.developing.java.users.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private int phoneNumber;
}
