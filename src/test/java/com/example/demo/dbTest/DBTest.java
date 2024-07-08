package com.example.demo.dbTest;

import com.example.demo.repository.TestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DBTest {

    @Autowired
    private TestRepository testRepository;

    @Test
    public void connectDBTest(){
        System.out.println(testRepository.findAll());
    }
}
