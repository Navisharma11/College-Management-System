package com.navisharma.collegemanagementsystem.service;

import com.navisharma.collegemanagementsystem.StudentNotFound;
import com.navisharma.collegemanagementsystem.model.Student;
import com.navisharma.collegemanagementsystem.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService
{
    private StudentRepository repo;

    @Autowired
    public void setRepo(StudentRepository repo)
    {
        this.repo=repo;
    }

    @Override
    public Integer registerStudent(Student student)
    {
        Student st = repo.save(student);
        Integer id = st.getId();
        return id;
    }

    @Override
    public String registerAllStudents(List<Student> students) {
        repo.saveAll(students);
        return "All Students Data Are Registered Successfully";
    }


    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Student getStudentDetailsById(Integer id) throws StudentNotFound {
        Optional<Student> optional = repo.findById(id);
        if(optional.isPresent())
        {
            return optional.get();
        }
        else
        {
            throw new StudentNotFound("Student With Given Id Is Not Found");
        }
    }

    @Override
    public List<Student> filterByCategory(String category) {
        return repo.findByCategory(category);
    }

    @Override
    public List<Student> filterByBranch(String branch) {
        return repo.findByBranch(branch);
    }

    @Override
    public List<Student> filterByYear(Integer year) {
        return repo.findByYear(year);
    }

    @Override
    public String updateStudent(Integer id, Student updatedStudent) throws StudentNotFound {
        Optional<Student> optional = repo.findById(id);
        if(optional.isPresent())
        {
            Student student = optional.get();

            student.setFirstName(updatedStudent.getFirstName());
            student.setLastName(updatedStudent.getLastName());
            student.setAge(updatedStudent.getAge());
            student.setGender(updatedStudent.getGender());
            student.setEmail(updatedStudent.getEmail());
            student.setPhoneNumber(updatedStudent.getPhoneNumber());
            student.setYear(updatedStudent.getYear());
            student.setCategory(updatedStudent.getCategory());
            student.setBranch(updatedStudent.getBranch());
            student.setCity(updatedStudent.getCity());


            repo.save(student);

            return "Student Updated Successfully";
        }
        else
        {
            throw new StudentNotFound("Student With Given Id Is Not Found");
        }
    }

    @Override
    public String deleteStudentInfo(Integer id) throws StudentNotFound {
        Optional<Student> optional = repo.findById(id);

        if(optional.isPresent())
        {
            repo.deleteById(id);
            return "Student Information Deleted Successfully";
        }
        else
        {
            throw new StudentNotFound("Student With Given Id Is Not Found To Delete");
        }
    }

    @Override
    public List<Student> searchStudentByName(String name) {
        return repo.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name,name);
    }

    @Override
    public Page<Student> getStudentsByPage(int page, int size) {

        Pageable pageable = PageRequest.of(page,size);

        return repo.findAll(pageable);
    }

}

