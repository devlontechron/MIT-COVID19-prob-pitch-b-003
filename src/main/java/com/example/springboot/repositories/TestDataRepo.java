package com.example.springboot.repositories;

import com.example.springboot.model.Civilian;
import com.example.springboot.model.TestData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDataRepo extends CrudRepository<TestData, Integer> {

    TestData findByTestId(String id);

}
