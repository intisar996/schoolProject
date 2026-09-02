package com.example.demo.controller;


import com.example.demo.DTO.SchoolDTO;
import com.example.demo.entities.School;
import com.example.demo.entities.Student;
import com.example.demo.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("s")
@CrossOrigin(origins = "*")

public class SchoolController {


  SchoolService schoolService;

  @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("add")
    public Long addShcool(@RequestParam String name, @RequestParam String location) {
        return schoolService.createSchool(name,location) ;

    }


    @GetMapping("getAll")
    public List<SchoolDTO> getAllSchool(){

       List<SchoolDTO>  schools = SchoolDTO.convertToDTO(schoolService.getAllSchools());
       return schools;
    }


    @GetMapping("getAllStudent")
    public List<Student> getAllStudentBySchoolId(@RequestParam Long id){
       return  schoolService.getAllStudentInSchool(id);
    }




    @GetMapping("getById")
    public SchoolDTO getById(@RequestParam Long id){
        return   SchoolDTO.convertToDTO(schoolService.getById(id));
    }


    @PutMapping("updateById")
    public School updateById(@RequestParam Long id, @RequestParam String name, @RequestParam String location){
        return schoolService.update(id,name,location);
    }


    @PutMapping("delete")
    public Boolean delete(@RequestParam Long id ) {
        return schoolService.deleteById(id);
    }






}
