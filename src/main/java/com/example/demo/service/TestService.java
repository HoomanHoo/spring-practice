package com.example.demo.service;

import com.example.demo.dto.TestDto;
import com.example.demo.entity.TestDb;
import com.example.demo.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService (TestRepository testRepository){
        this.testRepository = testRepository;
    }

    public List<?> findAllData(){
        List<TestDto> testDtoList = new ArrayList<>();
        testRepository.findAll()   //Dto - Entity간의 데이터 매핑은 외부 라이브러리, 혹은 로직을 DTO 클래스나 Entity 클래스 내부에 만들 수도 있다.
                .stream()
                .forEach(testDb -> {
                    TestDto testDto = new TestDto();
                    testDto.setId(testDb.getId());
                    testDto.setName(testDb.getName());
                    testDto.setPassword(testDb.getPasswd());
                    testDtoList.add(testDto);
                });
        return testDtoList;

    };

    public List<?> createUser(TestDto testDto){
        System.out.println(testDto.toString());
        Long recentId = testRepository.findTop1ByOrderByIdDesc().getId();
        TestDb testDb = new TestDb();
        testDb.setId(recentId + 1);
        testDb.setName(testDto.getName());
        testDb.setPasswd(testDto.getPassword());
        testRepository.save(testDb);

        return this.findAllData();
    }

    public List<?> updateUser(TestDto testDto){
        Optional<TestDb> user = testRepository.findById(testDto.getId());
        user.ifPresent(testDb -> {
            testDb.setName(testDto.getName());
            testRepository.save(testDb);
        });
        return this.findAllData();

    }

    public List<?> deleteUser(Long id){
        testRepository.deleteById(id);
        return this.findAllData();
    }
}
