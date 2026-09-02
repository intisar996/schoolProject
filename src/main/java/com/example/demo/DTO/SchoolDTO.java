package com.example.demo.DTO;


import com.example.demo.entities.School;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class SchoolDTO{

    private Long schoolId;
    private String schoolName;
    private String schoolLocation;



     public  static SchoolDTO convertToDTO(School entity){

        SchoolDTO dto =  SchoolDTO.builder()
                .schoolId(entity.getId())
                .schoolName(entity.getName())
                .schoolLocation(entity.getLocation())
                .build();
        return dto;


    }

    public static List<SchoolDTO> convertToDTO(List<School> entityList){
         List<SchoolDTO> dtos = new ArrayList<>();
         for(School s : entityList) {
             dtos.add(convertToDTO(s));
         }

         return  dtos;
    }








}
