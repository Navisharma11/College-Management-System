package com.navisharma.collegemanagementsystem.repo;

import com.navisharma.collegemanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{
    List<Student> findByCategory(String category);

    List<Student> findByBranch(String branch);

    List<Student> findByYear(Integer year);

    List<Student> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);

}
