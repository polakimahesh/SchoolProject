package com.studentdemo.StudentProject.Student;

import com.studentdemo.StudentProject.classObj.ClassDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
        @Autowired
        private StudentService studentService;
        @GetMapping("/users")
        public ResponseEntity<List<Student>> getAllStudents(){
                List<Student> allStudents=studentService.findAll();
                if ( allStudents== null)
                        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                else if ( allStudents.isEmpty())
                        return new ResponseEntity<>( allStudents, HttpStatus.NO_CONTENT);
                else return new ResponseEntity<>( allStudents, HttpStatus.OK);
        }
        @PostMapping("")
        public Student addStudent(@RequestBody Student student){
                return  studentService.addStudent(student);
        }

        @PostMapping("/register")
        public ResponseEntity<StudentDTO> creteClass(@RequestBody  StudentDTO studentDTO){
                return new ResponseEntity<>(studentService.creteStudent(studentDTO),HttpStatus.CREATED);
        }
}
