package com.m3.heekim.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.m3.heekim.rest.model.Student;
import com.m3.heekim.rest.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo repo;

	public List<Student> listAll() {
		System.out.println(repo.findAll());
		return repo.findAll();
	}

	public void save(Student std) {
		repo.save(std);
	}

	public Student get(long id) {
		return repo.findById(id).get();
	}

	public void delete(long id) {
		repo.deleteById(id);
	}

}
