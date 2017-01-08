package lesp.controller;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import lesp.service.ObservableStudentService;
import lesp.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import static org.springframework.web.servlet.mvc.method.annotation.SseEmitter.event;

@RestController
public class SseStudentController {
    @Autowired
    ObservableStudentService service;

    @RequestMapping("/sse/students")
    public SseEmitter getStudents() {
        SseEmitter emitter = new SseEmitter();

        Observable<Student> observable = service.getAllStudents();
        observable.subscribeOn(Schedulers.newThread())
                .subscribe(student -> {
                            emitter.send(event().data(student, MediaType.APPLICATION_JSON));
                        },
                        emitter::completeWithError,
                        emitter::complete);

        return emitter;
    }
}
