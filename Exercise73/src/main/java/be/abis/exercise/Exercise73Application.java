package be.abis.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Exercise73Application {

    public static void main(String[] args) {
        SpringApplication.run(Exercise73Application.class, args);
    }

}
