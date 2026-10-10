package com.navisharma.collegemanagementsystem.service;

import com.navisharma.collegemanagementsystem.StudentNotFound;
import com.navisharma.collegemanagementsystem.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;


public interface IStudentService
{
    Integer registerStudent(Student student);

    String registerAllStudents(List<Student> students);

    List<Student> getAllStudents();

    Student getStudentDetailsById(Integer id) throws StudentNotFound;

    List<Student> filterByCategory(String category);

    List<Student> filterByBranch(String branch);

    List<Student> filterByYear(Integer year);

    String updateStudent(Integer id,Student student) throws StudentNotFound;

    String deleteStudentInfo(Integer id) throws StudentNotFound;

    List<Student> searchStudentByName(String name);

    Page<Student> getStudentsByPage(int page,int size);
}
