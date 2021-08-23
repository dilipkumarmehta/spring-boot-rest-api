package com.ubs.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ubs.demo.model.Student;
import com.ubs.demo.services.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> list() {
		List<Student> studentList = studentService.getAllStudents();
		return new ResponseEntity<>(studentList, HttpStatus.OK);
	}

	@RequestMapping(value = "/editStudent/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> editStudent(@PathVariable int id) {
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ResponseEntity<Object> add(@RequestBody Student student) {
		studentService.addStudent(student);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteStudent/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> delete(@PathVariable("id") int id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

}