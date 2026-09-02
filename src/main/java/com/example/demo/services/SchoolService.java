package com.example.demo.services;


import com.example.demo.entities.School;
import com.example.demo.entities.Student;
import com.example.demo.repositories.SchoolRepository;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    SchoolRepository schoolRepository;
    StudentRepository studentRepository;


    @Autowired
    public SchoolService(SchoolRepository schoolRepository, StudentRepository studentRepository) {
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
    }
// add

     public Long createSchool(String name, String location){
        School school = new School();
        school.setIsActive(true);
        school.setCreatedDate(new Date());
        school.setName(name);
        school.setLocation(location);

        school = schoolRepository.save(school);
        return school.getId();


     }



     public List<School> getAllSchools(){
        return  schoolRepository.getAllSchool();

     }


    public List<Student> getAllStudentInSchool(Long id){
        return  schoolRepository.getAllStudent(id);

    }


     public  School getById(Long id){

       Optional<School>  school = schoolRepository.findById(id);

       if(school.isPresent()  && school.get().getIsActive() ){
           return school.get();
       }
           return new School();
       }




       public School update(Long id , String name, String location){
        School schoolToUpdate = schoolRepository.getById(id);
         if(schoolToUpdate == null){
             return new School();
         }
         schoolToUpdate.setUpdatedDate(new Date());
         schoolToUpdate.setName(name);
         schoolToUpdate.setLocation(location);
         schoolToUpdate = schoolRepository.save(schoolToUpdate);
         return schoolToUpdate;

       }

     public Boolean deleteById(Long id){
        School schoolToDelete = schoolRepository.getById(id);
        if(schoolToDelete == null){
            return false;
        }
         schoolToDelete.setIsActive(false);
         schoolToDelete.setUpdatedDate(new Date());
         schoolToDelete = schoolRepository.save(schoolToDelete);
        return  true;
     }









}
