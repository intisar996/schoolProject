package com.example.demo.controller;


import com.example.demo.DTO.SchoolDTO;
import com.example.demo.DTO.StudentDTO;
import com.example.demo.entities.School;
import com.example.demo.entities.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.DTO.StudentDTO.convertToDTO;

@RestController
@RequestMapping("student")
@CrossOrigin(origins = "*")
public class StudentController {


    StudentService studentService;


    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("add")
    public StudentDTO addStudent(
            @RequestParam String name,
            @RequestParam String major,
            @RequestParam String gender,
            @RequestParam String phoneNumber,
            @RequestParam String parentName,
            @RequestParam Long schoolId
    ){
        return convertToDTO(studentService.addStudent(name,major,gender,phoneNumber,parentName,schoolId));
    }


    @GetMapping("getAll")
    public List<StudentDTO> getAll(){
       return    StudentDTO.convertToDTO(studentService.getAllStudent());
    }


    @GetMapping("getById")
    public StudentDTO getById(@RequestParam Long id){
        return   StudentDTO.convertToDTO(studentService.getById(id));
    }


    @PutMapping("updateById")
    public Student updateById(@RequestParam Long id, @RequestParam String name, @RequestParam String major){
        return studentService.update(id,name,major);
    }


    @PutMapping("delete")
    public Boolean delete(@RequestParam Long id ) {
        return studentService.deleteById(id);
    }




}
