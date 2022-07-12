package com.m3.heekim.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3.heekim.rest.model.Student;
//import com.m3.heekim.rest.repo.StudentRepo;
import com.m3.heekim.rest.services.StudentService;


//@Controller
//@RequestMapping("/Student")
@RestController
public class ApiControllers {

	@Autowired
    private StudentService service;
//	@Autowired
//	private StudentRepo studentRepo;
	
//	@GetMapping(value= "/")
//	public String getPage() {
//		return "Welcome";
//	}
	
	@GetMapping(value= "/students")
	public List<Student> getStudents() {
		return service.listAll();
	}
	
	@PostMapping(value= "/addstudent")
	public String saveStudent(@RequestBody Student student) {
		service.save(student);
		return "Student created and saved...";
	}
	
	@PutMapping(value= "update/{id}")
	public String updateStudent(@PathVariable long id, @RequestBody Student student) {
		
		Student updatedStudent = service.get(id);
		updatedStudent.setFirstName(student.getFirstName());
		updatedStudent.setLastName(student.getLastName());
		updatedStudent.setAge(student.getAge());
		updatedStudent.setAddress(student.getAddress());
		updatedStudent.setPostcode(student.getPostcode());
		service.save(updatedStudent);
		return "Student updated...";
	}
	
	@DeleteMapping(value= "/delete/{id}")
	public String deleteStudent(@PathVariable long id) {
		Student deleteStudent = service.get(id);
		service.delete(deleteStudent.getId());
		return "Deleted the user ";
	}
	
	
	
	
	
	
	
}
