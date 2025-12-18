package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.studentEntity;
import com.example.demo.repository.studentRepo;
import com.example.demo.service.studentService;
import com.example.demo.exception.*;

import java.util.*;

@Service
public class studentServiceImpl implements studentService {

    @Autowired
    studentRepo repo;

    @Override
    public List<studentEntity> getAll() {
        return repo.findAll();
    }

    @Override
    public studentEntity addStudent(studentEntity student) {
        return repo.save(student);
    }

    @Override
    public studentEntity getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student is not Found"));
    }

    @Override
    public String updateStudent(Long id, studentEntity newstu) {
        if (repo.existsById(id)) {
            newstu.setId(id);
            repo.save(newstu);
            return "Student updated";
        }
        return "Student not found";
    }

    @Override
    public String deleteStudent(long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Student deleted";
        }
        return "Student not found";
    }
}