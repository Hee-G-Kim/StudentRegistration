package com.m3.heekim.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m3.heekim.rest.model.Student;

public interface StudentRepo extends JpaRepository<Student , Long>{

}
