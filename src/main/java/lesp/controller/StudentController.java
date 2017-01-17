package lesp.controller;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import lesp.service.StudentService;
import lesp.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;


@RestController
public class StudentController {
    @Autowired
    StudentService service;

    @RequestMapping("/students")
    public List<Student> getStudents() {
        return service.getAllStudents();
    }

    @RequestMapping("/sse/students")
    public SseEmitter getSSeStudents() {
        SseEmitter sseEmitter = new SseEmitter();
        Observable<Student> observable = service.getAllStudentsObservable();

        observable.subscribeOn(Schedulers.newThread())
                .map(student -> SseEmitter.event().data(student, MediaType.APPLICATION_JSON))
                .subscribe(
                        sseEmitter::send,
                        sseEmitter::completeWithError,
                        sseEmitter::complete);
        return sseEmitter;
    }
}
