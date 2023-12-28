package com.onadebi.demo.student;

import com.onadebi.demo.student.dto.StudentUpdateDTO;
import com.onadebi.demo.student.services.IStudentService;
import com.onadebi.demo.student.services.StudentService;
import com.onadebi.demo.utils.GenResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final IStudentService _studentService;
//    @Value("${spring.config.activate.on-profile}")
//    private String _profile;

    @Autowired
    public StudentController(StudentService studentService) {
        this._studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return _studentService.getStudents();
    }

    @PostMapping
    public GenResponse<Student> registerNewStudent(@RequestBody Student student){
        return _studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public GenResponse<Student> registerNewStudent(@PathVariable("studentId") Long studentId){
        return _studentService.deleteStudent(studentId);
    }

    @PutMapping(path="{studentId}")
    public GenResponse<StudentUpdateDTO> registerNewStudent(@PathVariable("studentId") Long studentId, @RequestBody StudentUpdateDTO student){
        return _studentService.updateStudent(studentId, student);
    }

}
