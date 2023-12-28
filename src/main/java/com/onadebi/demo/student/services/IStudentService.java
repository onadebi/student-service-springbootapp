package com.onadebi.demo.student.services;
import com.onadebi.demo.student.Student;
import com.onadebi.demo.student.dto.StudentUpdateDTO;
import com.onadebi.demo.utils.GenResponse;

import java.util.List;
public interface IStudentService {
    List<Student> getStudents();

    GenResponse<Student> addNewStudent(Student student);

    GenResponse<Student> deleteStudent(Long studentId);

    GenResponse<StudentUpdateDTO> updateStudent(Long studentId, StudentUpdateDTO student);
}
