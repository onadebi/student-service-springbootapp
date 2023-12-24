package com.onadebi.demo.student.services;

import com.onadebi.demo.student.Student;
import com.onadebi.demo.student.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentService implements IStudentService {

    private final StudentRepository _studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this._studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        List<Student> students = _studentRepository.findAll();
        // return List.of(
        //         new Student(1L,"Onaefe Edebi", "onaefe@onadebi.com", LocalDate.of(2023, Calendar.SEPTEMBER,23), 150)
        //         ,new Student(2L,"John Doe", "j.doe@onadebi.com", LocalDate.of(2023, Calendar.SEPTEMBER,23), 250)
        // );
        return students;
    }
}

