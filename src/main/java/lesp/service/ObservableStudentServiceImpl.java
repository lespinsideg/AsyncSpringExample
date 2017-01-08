package lesp.service;

import io.reactivex.Observable;
import lesp.vo.Student;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class ObservableStudentServiceImpl implements ObservableStudentService {
    private int i = 1;
    @Override
    public Observable<Student> getAllStudents() {
        return getStudents();
    }

    private Observable<Student> getStudents() {
        return Observable.create(s -> {
            for(int i = 0 ; i < 10 ; i++) {
                s.onNext(getStudent());
            }

            s.onComplete();
        });
    }

    private Student getStudent() throws Exception {
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
