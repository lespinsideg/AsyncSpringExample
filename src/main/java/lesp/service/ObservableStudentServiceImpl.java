package lesp.service;

import io.reactivex.Observable;
import lesp.vo.Student;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class ObservableStudentServiceImpl implements ObservableStudentService {
    @Override
    public Observable<Student> getAllStudents() {
        return getStudents();
    }

    private Observable<Student> getStudents() {
        return Observable.create(s -> {
            for(int i = 0 ; i < 10 ; i++) {
                s.onNext(getStudentFromAPI(i));
            }

            s.onComplete();
        });
    }

    private Student getStudentFromAPI(int studentNumber) throws Exception {
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
