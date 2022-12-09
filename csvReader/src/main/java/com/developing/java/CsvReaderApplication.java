package com.developing.java;

import com.developing.java.users.reader.BeanBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class CsvReaderApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(CsvReaderApplication.class, args);

        BeanBuilder beanBuilder = new BeanBuilder();
        beanBuilder.reader();
    }
}
