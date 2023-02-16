package com.studentdemo.StudentProject.classObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping(value = "")
    public ResponseEntity<List<ClassObj>> getAllClasses(){
        List<ClassObj> allClass = classService.findAll();
        if (allClass == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if (allClass.isEmpty())
            return new ResponseEntity<>(allClass, HttpStatus.NO_CONTENT);
        else return new ResponseEntity<>(allClass, HttpStatus.OK);

    }
    @PostMapping("")
    public ClassObj addClass(@RequestBody ClassObj classObj){
        return  classService.addClass(classObj);
    }
    @PostMapping("/register")
    public ResponseEntity<ClassDTO> creteClass(@RequestBody  ClassDTO classDTO){
        return new ResponseEntity<>(classService.creteClass(classDTO),HttpStatus.CREATED);
    }

}
