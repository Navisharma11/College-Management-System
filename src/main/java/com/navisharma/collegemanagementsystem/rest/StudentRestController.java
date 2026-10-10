package com.navisharma.collegemanagementsystem.rest;

import com.navisharma.collegemanagementsystem.StudentNotFound;
import com.navisharma.collegemanagementsystem.model.Student;
import com.navisharma.collegemanagementsystem.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRestController
{
    private IStudentService service;

    @Autowired
    public void setService(IStudentService service)
    {
        this.service=service;
    }

    @PostMapping("/register-student")
    public ResponseEntity<String> regStudent(@RequestBody Student student)
    {
        Integer id = service.registerStudent(student);
        String status = "Student Registered Successfully With Student Id :" + id;
        return new ResponseEntity<String>(status, HttpStatus.CREATED);
    }


    @PostMapping("/registerAllStudents")
    public ResponseEntity<String> regAllStudents(@RequestBody List<Student> students)
    {
        String status = service.registerAllStudents(students);
        return new ResponseEntity<String>(status,HttpStatus.CREATED);
    }


    @GetMapping("/get-All-Students-Info")
    public ResponseEntity<List<Student>> getAllStudentsInformation()
    {
        List<Student> students = service.getAllStudents();
        return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
    }


    @GetMapping("/get-Student-By-Id/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) throws StudentNotFound {
        Student student = service.getStudentDetailsById(id);
        return new ResponseEntity<Student>(student,HttpStatus.OK);
    }


    @GetMapping("/get-Students-By-Category/{category}")
    public ResponseEntity<List<Student>> getStudentsByCategory(@PathVariable String category)
    {
        List<Student> students = service.filterByCategory(category);
        return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
    }

    @GetMapping("/get-Students-By-Branch/{branch}")
    public ResponseEntity<List<Student>> getStudentsByBranch(@PathVariable String branch)
    {
        List<Student> students = service.filterByBranch(branch);
        return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
    }

    @GetMapping("/get-Students-By-Year/{year}")
    public ResponseEntity<List<Student>> getStudentsByYear(@PathVariable Integer year)
    {
        List<Student> students = service.filterByYear(year);
        return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
    }

   @PutMapping("/update-Student/{id}")
   public ResponseEntity<String> updateStudentInfo(@PathVariable Integer id,@RequestBody Student updatedStudent) throws StudentNotFound {
       String status = service.updateStudent(id,updatedStudent);
       return new ResponseEntity<String>(status,HttpStatus.OK);
   }


   @DeleteMapping("/delete-Student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) throws StudentNotFound
   {
       String status = service.deleteStudentInfo(id);
       return new ResponseEntity<String>(status,HttpStatus.OK);
   }

   @GetMapping("/getByName/{name}")
   public ResponseEntity<List<Student>> getStudentsByName(@PathVariable String name)
   {
       List<Student> students = service.searchStudentByName(name);
       return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
   }



}
