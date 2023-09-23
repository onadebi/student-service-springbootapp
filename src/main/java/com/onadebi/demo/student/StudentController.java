package com.onadebi.demo.student;

import com.onadebi.demo.student.services.IStudentService;
import com.onadebi.demo.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final IStudentService _studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this._studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return _studentService.getStudents();
    }

}
