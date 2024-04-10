package edu.miu.service;

import edu.miu.service.domain.ExecutionTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class AopAssignmentApplication {

    @ExecutionTime
    public static void main(String[] args) {
        SpringApplication.run(AopAssignmentApplication.class, args);
    }

}
