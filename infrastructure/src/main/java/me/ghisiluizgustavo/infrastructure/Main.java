package me.ghisiluizgustavo.infrastructure;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(scanBasePackages = {
        "me.ghisiluizgustavo.infrastructure",
        "me.ghisiluizgustavo.usecase"
})
@RequiredArgsConstructor
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}