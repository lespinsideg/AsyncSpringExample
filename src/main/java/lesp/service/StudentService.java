package lesp.service;

import io.reactivex.Observable;
import lesp.vo.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Observable<Student> getAllStudentsObservable();
}
