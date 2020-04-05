package com.example.springboot.repositories;

import com.example.springboot.model.Civilian;
import com.example.springboot.model.Organizations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgRepo extends CrudRepository<Organizations, Integer> {
}
