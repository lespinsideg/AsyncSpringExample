package lesp.service;

import io.reactivex.Observable;
import lesp.vo.Student;

public interface ObservableStudentService {
    Observable<Student> getAllStudents();
}
