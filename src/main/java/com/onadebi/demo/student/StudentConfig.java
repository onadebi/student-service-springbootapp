package com.onadebi.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import java.util.Optional;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        Optional<Student> optionalStudent = studentRepository.findTopByOrderByIdAsc();
        if(optionalStudent.isPresent()) {
            System.out.println("At least one Student record exists: " + optionalStudent.get().getName());
            return null;
        } else {
            System.out.println("No Student record in db. Populating db with sample data...");
             return args -> {
                List<Student> allStudents = List.of(
                        new Student("Onaefe Edebi", "onaefe@onadebi.com", LocalDate.of(1990, Calendar.SEPTEMBER, 23)),
                        new Student("John Doe", "j.doe@onadebi.com", LocalDate.of(1980, Calendar.SEPTEMBER, 23)));
                
                studentRepository.saveAll(allStudents);
            };
        }
       
    }
}
