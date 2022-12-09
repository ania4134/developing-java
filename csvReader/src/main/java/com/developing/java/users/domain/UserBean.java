package com.developing.java.users.domain;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {

    @CsvBindByName(column = "first_name", required = true)
    private String firstName;

    @CsvBindByName(column = "last_name", required = true)
    private String lastName;

    @CsvBindByName(column = "birth_date", required = true)
    @CsvDate("yyyy.MM.dd")
    private Date birthDate;

    @CsvBindByName(column = "phone_no")
    private int phoneNo;
}
