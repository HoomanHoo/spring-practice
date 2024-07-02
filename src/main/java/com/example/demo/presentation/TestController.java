package com.example.demo.presentation;

import com.example.demo.dto.TestDto;
import com.example.demo.service.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService){
        this.testService = testService;
    }

    @GetMapping("/list")
    public List<?> getList(){
        return testService.findAllData();
    }

    @PostMapping("/create")
    public List<?> createUser(@RequestBody TestDto testDto){
        return testService.createUser(testDto);
    }

    @PutMapping("/update")
    public List<?> updateUser(Long id){
        return testService.updateUser(id);
    }

    @DeleteMapping("/delete")
    public List<?> deleteUser(Long id){
        return testService.deleteUser(id);
    }
}
