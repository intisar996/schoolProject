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
public class StudentService {


    StudentRepository studentRepository;
    SchoolService schoolService;
    SchoolRepository schoolRepository;

    @Autowired
    public StudentService(SchoolRepository schoolRepository, SchoolService schoolService, StudentRepository studentRepository) {
        this.schoolRepository = schoolRepository;
        this.schoolService = schoolService;
        this.studentRepository = studentRepository;
    }

    // add
    public Student addStudent(String name, String major, String gender,
                              String phoneNumber, String parentName, Long schoolId) {
        School school = schoolService.getById(schoolId);
        if(school == null || school.getIsActive() == false){
            return new Student();
        }

        Student student = new Student();
        student.setName(name);
        student.setMajor(major);
        student.setGender(gender);
        student.setPhoneNumber(phoneNumber);
        student.setParentName(parentName);
        student.setIsActive(true);
        student.setCreatedDate(new Date());
        Student savedStudent = studentRepository.save(student);

        List<Student> studentList = school.getStudents();
        studentList.add(savedStudent);
        school.setStudents(studentList);
        schoolRepository.save(school);

        return savedStudent;
    }



     public List<Student> getAllStudent(){
       return  studentRepository.getAllStudent();
     }





    public  Student getById(Long id){

        Optional<Student> student = studentRepository.findById(id);

        if(student.isPresent()  && student.get().getIsActive() ){
            return student.get();
        }
        return new Student();
    }





    public Student update(Long id , String name, String major){
        Student studentToUpdate = studentRepository.getById(id);
        if(studentToUpdate == null){
            return new Student();
        }
        studentToUpdate.setUpdatedDate(new Date());
        studentToUpdate.setName(name);
        studentToUpdate.setMajor(major);
        studentToUpdate = studentRepository.save(studentToUpdate);
        return studentToUpdate;

    }



    public Boolean deleteById(Long id){
        Student studentToUpdate = studentRepository.getById(id);
        if(studentToUpdate == null){
            return false;
        }
        studentToUpdate.setIsActive(false);
        studentToUpdate.setUpdatedDate(new Date());
        studentToUpdate = studentRepository.save(studentToUpdate);
        return  true;
    }

}
