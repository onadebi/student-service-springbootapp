package com.onadebi.demo.student.services;

import com.onadebi.demo.student.Student;
import com.onadebi.demo.student.StudentRepository;
import com.onadebi.demo.utils.*;

import io.micrometer.common.util.StringUtils;

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

    public List<Student> getStudents() {
        List<Student> students = _studentRepository.findAll();
        // return List.of(
        // new Student(1L,"Onaefe Edebi", "onaefe@onadebi.com", LocalDate.of(2023,
        // Calendar.SEPTEMBER,23), 150)
        // ,new Student(2L,"John Doe", "j.doe@onadebi.com", LocalDate.of(2023,
        // Calendar.SEPTEMBER,23), 250)
        // );
        return students;
    }

    @Override
    public GenResponse<Student> addNewStudent(Student student) {
        GenResponse<Student> response = new GenResponse<Student>();
        try {
            if (student != null) {
                if (StringUtils.isBlank(student.getName()) || StringUtils.isBlank(student.getEmail())
                        || student.getDob() == null) {
                    throw new IllegalStateException("Student cannot be null");
                }else if(_studentRepository.findStudentByEmail(student.getEmail()).isPresent()){
                    response = GenResponse.failed(null, "Student not added. Email already in use.");
                } else {
                   Student data= _studentRepository.save(student);
                   if (data != null) {
                    response = GenResponse.success(data, "Student added successfully");
                   } else {
                    response = GenResponse.failed(data, "Student not added successfully");
                   }
                }
            }
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }
}
