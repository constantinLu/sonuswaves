package com.youtube.sonuswaves;

import com.youtube.sonuswaves.process.InitBatchProcesses;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SonuswavesApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SonuswavesApplication.class, args);
        InitBatchProcesses init = new InitBatchProcesses();
        init.initialize();
    }
}
