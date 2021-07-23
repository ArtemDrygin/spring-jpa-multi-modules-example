package com.example.springjpamultimodulesexample.db.module;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DbModuleTests.class)
class DbModuleTests {

    @Test
    void contextLoads() {
        System.out.println("test");
    }

}
