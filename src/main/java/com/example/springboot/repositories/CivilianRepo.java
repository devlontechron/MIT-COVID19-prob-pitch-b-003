package com.example.springboot.repositories;

import com.example.springboot.model.Civilian;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CivilianRepo extends CrudRepository<Civilian, Integer> {

}