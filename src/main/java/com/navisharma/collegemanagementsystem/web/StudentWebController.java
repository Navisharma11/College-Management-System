package com.navisharma.collegemanagementsystem.web;

import com.navisharma.collegemanagementsystem.StudentNotFound;
import com.navisharma.collegemanagementsystem.model.Student;
import com.navisharma.collegemanagementsystem.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentWebController
{
    private IStudentService service;

    @Autowired
    public void setService(IStudentService service)
    {
        this.service=service;
    }


    @GetMapping("/")
    public String showRegisterPage(Model model) {

        model.addAttribute("student", new Student());

        return "register-student";
    }


    @PostMapping("/registerStudent")
    public String regStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes)
    {
        Integer id = service.registerStudent(student);
        redirectAttributes.addFlashAttribute("successMessage", "Student Registered Successfully! Your Student ID is: " + id);
        return "redirect:/";
    }


    @GetMapping("/viewAllStudents")
    public String getAllStudentsInformation(@RequestParam(defaultValue = "0") int page, Model model)
    {
        int size = 20;
        Page<Student> studentPage = service.getStudentsByPage(page,size);
        model.addAttribute("studentInfo",studentPage.getContent());
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",studentPage.getTotalPages());
        model.addAttribute("totalStudents",studentPage.getTotalElements());
        return "allStudents";
    }


    @GetMapping("/editStudent/{id}")
    public String showEditStudentPage(@PathVariable Integer id,Model model) throws StudentNotFound {
        Student student = service.getStudentDetailsById(id);
        model.addAttribute("student",student);
        return "update-student";
    }


    @PostMapping("/updateStudent/{id}")
    public String updateStudentInfo(@PathVariable Integer id,@ModelAttribute Student updatedStudent) throws StudentNotFound {
        service.updateStudent(id,updatedStudent);
        return "redirect:/viewAllStudents";
    }


    @PostMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Integer id) throws StudentNotFound
    {
        service.deleteStudentInfo(id);
        return "redirect:/viewAllStudents";
    }


    @GetMapping("/findByName")
    public String searchByName(@RequestParam String name,Model model)
    {
        List<Student> students = service.searchStudentByName(name);
        model.addAttribute("studentInfo",students);
        return "allStudents";
    }

    @GetMapping("/filterByBranch")
    public String filterByBranch(@RequestParam String branch,Model model)
    {
        List<Student> students = service.filterByBranch(branch);
        model.addAttribute("studentInfo",students);
        return "allStudents";
    }
}
