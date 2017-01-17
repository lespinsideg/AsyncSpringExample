package lesp.service;

import io.reactivex.Observable;
import lesp.vo.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        for(int i = 0 ; i < 10 ; i++) {
            students.add(getStudentFromAPI(i));
        }

        return students;
    }

    @Override
    public Observable<Student> getAllStudentsObservable() {
        Observable<Student> observable = Observable.create(e -> {
            for(int i =0  ; i < 10 ; i++) {
                e.onNext(getStudentFromAPI(i));
            }

            e.onComplete();
        });

        return observable;
    }

    private Student getStudentFromAPI(int studentNumber) {
        sleep();
        return new Student("student " + studentNumber);
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
