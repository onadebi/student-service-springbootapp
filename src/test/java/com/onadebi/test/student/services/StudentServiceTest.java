package com.onadebi.test.student.services;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.onadebi.demo.student.Student;
import com.onadebi.demo.student.StudentRepository;
import com.onadebi.demo.student.services.IStudentService;
import com.onadebi.demo.student.services.StudentService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

class StudentServiceTest {

    @Mock
    private StudentRepository _studentRepository;
    private IStudentService studentServiceTest;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        studentServiceTest = new StudentService(_studentRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllStudents() {
        // When : Act
        List<Student> allStudents =  studentServiceTest.getStudents();
        // Then: Assert that the student is found
        verify(_studentRepository).findAll();
    }

    @Test
    @Disabled
    void addNewStudent() {
    }

    @Test
    @Disabled
    void deleteStudent() {
    }

    @Test
    @Disabled
    void updateStudent() {
    }
}