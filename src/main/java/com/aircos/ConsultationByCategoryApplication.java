package com.aircos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.aircos.mapper")
public class ConsultationByCategoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsultationByCategoryApplication.class, args);
    }

}
