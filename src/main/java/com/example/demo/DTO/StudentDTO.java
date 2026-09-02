package com.example.demo.DTO;


import com.example.demo.entities.Student;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class StudentDTO {

    private Long studentId;
    private String studentName;
    private String parentName;
    private String studentMajor;
    private String studentGender;
    private String studentPhoneNumber;

    public static StudentDTO convertToDTO(Student entity){
        StudentDTO dto = StudentDTO.builder()
                .studentId(entity.getId())
                .studentName(entity.getName())
                .parentName(entity.getParentName())
                .studentMajor(entity.getMajor())
                .studentGender(entity.getGender())
                .studentPhoneNumber(entity.getPhoneNumber())
                .build();
        return dto;
    }

    public static List<StudentDTO> convertToDTO(List<Student> entityList){
        List<StudentDTO> dtos = new ArrayList<>();

        for (Student s : entityList) {
            dtos.add(convertToDTO(s));
        }

        return dtos;
    }






}
