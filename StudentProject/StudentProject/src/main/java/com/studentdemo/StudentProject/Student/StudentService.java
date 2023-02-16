package com.studentdemo.StudentProject.Student;

import com.studentdemo.StudentProject.classObj.ClassDTO;
import com.studentdemo.StudentProject.classObj.ClassObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return  studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        return  studentRepository.save(student);
    }

    public StudentDTO creteStudent(StudentDTO studentDTO){
        Student studentObj = studentDtoToEntity(studentDTO);
        Student savedStudent=   studentRepository.save(studentObj);
        return EntityTOStudentDto(savedStudent);
    }
    public Student studentDtoToEntity(StudentDTO studentDTO){
        Student studentObj = new Student();
        studentObj.setFirstName(studentDTO.getFirstName());
        studentObj.setLastName(studentDTO.getLastName());
        studentObj.setSection(studentDTO.getSection());
        return studentObj;
    }
    public  StudentDTO EntityTOStudentDto(Student studentObj){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentObj.getId());
        studentDTO.setFirstName(studentObj.getFirstName());
        studentDTO.setLastName(studentObj.getLastName());
        studentDTO.setSection(studentObj.getSection());
        return studentDTO;
    }

}
