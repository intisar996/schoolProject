package com.example.demo.repositories;

import com.example.demo.entities.School;
import com.example.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {


      @Query("SELECT s FROM School s WHERE s.isActive=true")
      List<School> getAllSchool();



      @Query(value = "SELECT s.* FROM Student s JOIN school_students ss ON s.id=ss.students_id where s.is_active=true AND ss.school_id =:id", nativeQuery = true)
      List<Student> getAllStudent(@Param("id") Long id);

      @Query("SELECT s FROM School s WHERE s.isActive=true  AND s.id=:id")
      School getById(@Param("id") Long id);

}
