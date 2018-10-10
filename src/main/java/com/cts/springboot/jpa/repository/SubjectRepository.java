package com.cts.springboot.jpa.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.springboot.jpa.entity.Subject;
@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long>{
}