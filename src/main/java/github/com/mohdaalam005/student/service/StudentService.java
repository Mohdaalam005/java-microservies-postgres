package github.com.mohdaalam005.student.service;

import github.com.mohdaalam005.student.entity.StudentEntity;
import github.com.mohdaalam005.student.mapper.StudentEntityMapper;
import github.com.mohdaalam005.student.model.StudentRequest;
import github.com.mohdaalam005.student.model.StudentResponse;
import github.com.mohdaalam005.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentEntityMapper studentEntityMapper;

    private final StudentRepository studentRepository;

    public StudentService(StudentEntityMapper studentEntityMapper, StudentRepository studentRepository) {
        this.studentEntityMapper = studentEntityMapper;
        this.studentRepository = studentRepository;
    }

    public List<StudentRequest> getStudents() {
        List<StudentEntity> students = studentRepository.findAll();
        return studentEntityMapper.toDtoS(students);
    }

    public StudentRequest getStudent(Long studentId) {
        StudentRequest studentRequest = null;
        Optional<StudentEntity> student = studentRepository.findById(studentId);

        if (student.isPresent()){
            studentRequest = studentEntityMapper.toDto(student.get()) ;
        }
        return studentRequest;

    }

    public StudentResponse createStudent(StudentRequest studentRequest) {
        StudentEntity studentEntity = studentEntityMapper.toEntity(studentRequest);
        studentRepository.save(studentEntity) ;
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(studentEntity.getId());
        return studentResponse;
    }
    public StudentRequest updateStudent(Long studentId , StudentRequest studentRequest){
        StudentRequest studentRequest1 = null ;
        Optional<StudentEntity> studentById = studentRepository.findById(studentId);
        if (studentById.isPresent()){
            StudentEntity studentEntity = studentEntityMapper.toEntity(studentRequest);
            studentEntity.setId(studentId);
            studentRepository.save(studentEntity) ;
            studentRequest1 = studentEntityMapper.toDto(studentEntity) ;

        }
        return studentRequest1 ;
    }

    public void deleteStudent(Long studentId){
        Optional<StudentEntity> byId = studentRepository.findById(studentId);
        if (byId.isPresent()){
            studentRepository.deleteById(studentId);
        }

    }
}
