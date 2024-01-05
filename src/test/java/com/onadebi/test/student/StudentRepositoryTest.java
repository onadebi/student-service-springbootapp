
package com.onadebi.test.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.onadebi.demo.student.Student;
import com.onadebi.demo.student.StudentRepository;
import com.onadebi.demo.DemoApplication;


@DataJpaTest
@ContextConfiguration(classes = DemoApplication.class)
class StudentRepositoryTest {

    // @Autowired
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testFindStudentByEmail() {
        // Given
        Student student = new Student();
        student.setEmail("test@example.com");
        studentRepository.save(student);

        // When
        Optional<Student> optionalStudent = studentRepository.findStudentByEmail("test@example.com");

        // Then:: Assert that the student is found
        assertTrue(optionalStudent.isPresent());
        assertEquals("test@example.com", optionalStudent.get().getEmail());
    }

    @Test
    public void testFindStudentByEmail_NotFound() {
        // Find a non-existent student by email
        Optional<Student> optionalStudent = studentRepository.findStudentByEmail("nonexistent@example.com");

        // Assert that the student is not found
        assertFalse(optionalStudent.isPresent());
    }
}