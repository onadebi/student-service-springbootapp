package com.onadebi.demo.student.services;

import com.onadebi.demo.student.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Service
public class StudentService implements IStudentService {
    public List<Student> getStudents(){
        return List.of(
                new Student(1L,"Onaefe Edebi", "onaefe@onadebi.com", LocalDate.of(2023, Calendar.SEPTEMBER,23), 150)
                ,new Student(2L,"John Doe", "j.doe@onadebi.com", LocalDate.of(2023, Calendar.SEPTEMBER,23), 250)
        );
    }
}

