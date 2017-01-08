package lesp.controller;

import lesp.service.StudentService;
import lesp.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StudentController {
    @Autowired
    StudentService service;

    @RequestMapping("/students")
    public List<Student> getStudents() {
        return service.getAllStudents();
    }
}
