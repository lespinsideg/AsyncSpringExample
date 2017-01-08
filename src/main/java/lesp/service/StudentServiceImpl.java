package lesp.service;

import lesp.vo.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class StudentServiceImpl implements StudentService {
    private int i  = 1;

    @Override
    public List<Student> getAllStudents() {
        return getStudents();
    }

    private List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        for(int i = 0 ; i < 10 ; i++) {
            students.add(getStudent());
        }

        return students;
    }

    private Student getStudent() {
        sleep();
        return new Student("student " + i++);
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
