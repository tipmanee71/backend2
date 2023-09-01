package com.example.demo.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository studentRepository;
	
	
	@GetMapping("/students")
	public ResponseEntity<Object> getStdId(){
		try {
			java.util.List<Student> student =  studentRepository.findAll();
			return new ResponseEntity<>(student, HttpStatus.OK);
		} catch (Exception e) {	
			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/students")
	public ResponseEntity<Object> addStudent(@RequestBody Student body){
		
		try {
			Student student = studentRepository.save(body);
			return new ResponseEntity<>(student, HttpStatus.CREATED);
		
		} catch (Exception e) {
			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/students/{Id}")
	public ResponseEntity<Object> updatstudent(@PathVariable String stdId, @RequestBody Student body){
		try {
			Optional<Student> student = studentRepository.findById(stdId);
			
			if (student.isPresent()) {
				Student studentEdit = student.get();
				studentEdit.setStdfirst(body.getStdfirst());
				studentEdit.setStdlast(body.getStdlast());
				studentEdit.setEmail(body.getEmail());
				studentEdit.setStdId(body.getStdId());
				
				studentRepository.save(studentEdit);
				
				return new ResponseEntity<>(studentEdit, HttpStatus.OK);
				} else {
					return new ResponseEntity<>("Student not found ", HttpStatus.BAD_REQUEST);
					
				}
			
		} catch (Exception e) {
			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
	}

