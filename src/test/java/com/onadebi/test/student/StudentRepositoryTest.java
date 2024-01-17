
package com.onadebi.test.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
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

    // @AfterAll
    // void tearDown() {
    //     studentRepository.deleteAll();
    // }

    @Test
    public void testFindStudentByEmail() {
        // Given: Arrange
        Student student = new Student();
        student.setEmail("test@example.com");
        studentRepository.save(student);

        // When: Act
        Optional<Student> optionalStudent = studentRepository.findStudentByEmail("test@example.com");

        // Then: Assert that the student is found
        assertTrue(optionalStudent.isPresent());
        assertEquals("test@example.com", optionalStudent.get().getEmail());
    }

    @Test
    public void testFindStudentByEmail_NotFound() {

        // Given : Arrange
        String studentEmail = "nonexistent@example.com";

        // When: Act
        Optional<Student> optionalStudent = studentRepository.findStudentByEmail(studentEmail);

        // Then: Assert that the student is not found
        assertFalse(optionalStudent.isPresent());
    }
}