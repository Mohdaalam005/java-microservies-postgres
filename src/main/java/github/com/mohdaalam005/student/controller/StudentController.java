package github.com.mohdaalam005.student.controller;

import github.com.mohdaalam005.student.model.StudentRequest;
import github.com.mohdaalam005.student.model.StudentResponse;
import github.com.mohdaalam005.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService ;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/students",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentRequest>>getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }
    @GetMapping(value = "/students/{studentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentRequest>getStudent(@PathVariable Long studentId){
        return new ResponseEntity<>(studentService.getStudent(studentId),HttpStatus.OK);
    }

    @PostMapping(value = "/students",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse>createStudent(@RequestBody StudentRequest studentRequest){
        return new ResponseEntity<>(studentService.createStudent(studentRequest),HttpStatus.CREATED);
    }

    @PutMapping(value = "/students/{studentId}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentRequest>updateStudent(@PathVariable Long studentId , @RequestBody StudentRequest studentRequest){
        return new ResponseEntity<>(studentService.updateStudent(studentId,studentRequest),HttpStatus.OK);
    }

    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<Void>deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok().build();
    }
}
