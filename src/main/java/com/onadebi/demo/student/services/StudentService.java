package com.onadebi.demo.student.services;

import com.onadebi.demo.student.Student;
import com.onadebi.demo.student.StudentRepository;
import com.onadebi.demo.student.dto.StudentUpdateDTO;
import com.onadebi.demo.utils.*;

import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    private final StudentRepository _studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this._studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        // #region OLD CODE
        // return List.of(
        // new Student(1L,"Onaefe Edebi", "onaefe@onadebi.com", LocalDate.of(2023,
        // Calendar.SEPTEMBER,23), 150)
        // ,new Student(2L,"John Doe", "j.doe@onadebi.com", LocalDate.of(2023,
        // Calendar.SEPTEMBER,23), 250)
        // );
        // #endregion
        List<Student> students = _studentRepository.findAll();
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
                } else if (_studentRepository.findStudentByEmail(student.getEmail()).isPresent()) {
                    response = GenResponse.failed(null, "Student not added. Email already in use.");
                } else {
                    Student data = _studentRepository.save(student);
                    if (data != null) {
                        response = GenResponse.success(data, "Student added successfully");
                    } else {
                        response = GenResponse.failed(data, "Student not added successfully");
                    }
                }
            }
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
            response = GenResponse.failed(null, "An internal error occured. Kindy retry again later",
                    StatusEnum.INTERNAL_SERVER_ERROR);
            throw new IllegalStateException(ex.getMessage());
        }
        return response;
    }

    @Override
    public GenResponse<Student> deleteStudent(Long studentId) {
        GenResponse<Student> response = new GenResponse<Student>();
        try {
            if (_studentRepository.existsById(studentId)) {
                _studentRepository.deleteById(studentId);
                response = GenResponse.success(null, "Student deleted successfully");
            } else {
                response = GenResponse.failed(null, "Student not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // throw new IllegalStateException(e.getMessage());
            response = GenResponse.failed(null, "An internal error occured. Kindy retry again later",
                    StatusEnum.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @Override
    @Transactional
    public GenResponse<StudentUpdateDTO> updateStudent(Long studentId, StudentUpdateDTO student) {
        GenResponse<StudentUpdateDTO> response = new GenResponse<StudentUpdateDTO>();
        String msg = "";
        try {
            Optional<Student> data = _studentRepository.findById(studentId);
            if (data == null) {
                response = GenResponse.failed(null, "Student not found", StatusEnum.NOT_FOUND);
            } else if (StringUtils.isBlank(student.name) || StringUtils.isBlank(student.email)) {
                response = GenResponse.failed(null, "Student name and email cannot be empty", StatusEnum.BAD_REQUEST);
            } else {
                Student studentData = data.get();
                if (!Objects.equals(data.get().getName(), student.name)) {
                    studentData.setName(student.name);
                    msg = "Name successfully updated";
                }
                if (!Objects.equals(data.get().getEmail(), student.email)) {
                    if (_studentRepository.findStudentByEmail(student.email).isPresent()) {
                        response = GenResponse.failed(null, "Student Email not updated. Email already in use.",
                                StatusEnum.NO_CHANGE);

                        if (!StringUtils.isBlank(msg)) {
                            response.message += " " + msg;
                            response.success = true;
                        }
                        return response;
                    } else {
                        studentData.setEmail(student.email);
                        return GenResponse.success(student, "Student record updated successfully");
                    }
                }
                if (!StringUtils.isBlank(msg)) {
                    return GenResponse.success(student, msg);
                }
                // _studentRepository.save(studentData); // There is no need for calling the
                // respository because this function is decorated with an @Transactional
                // annotation which automatically udates the data to the database without
                // calling the repository save method.
                // response = GenResponse.success(studentData, "Student updated successfully");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            response = GenResponse.failed(null, "An internal error occured. Kindy retry again later",
                    StatusEnum.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
