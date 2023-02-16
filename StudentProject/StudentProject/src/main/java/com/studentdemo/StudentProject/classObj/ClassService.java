package com.studentdemo.StudentProject.classObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public List<ClassObj> findAll() {
        return classRepository.findAll();
    }

    public ClassObj addClass(ClassObj classObj) {
        return classRepository.save(classObj);
    }

    public ClassDTO creteClass(ClassDTO classDTO){
        ClassObj classObj = classDtoToEntity(classDTO);
        ClassObj savedClass=   classRepository.save(classObj);
         return EntityTOClassDto(savedClass);
    }
    public ClassObj classDtoToEntity(ClassDTO classDTO){
        ClassObj classObj = new ClassObj();
        classObj.setName(classDTO.getName());
        return classObj;
    }
    public  ClassDTO EntityTOClassDto(ClassObj classObj){
        ClassDTO classDTO = new ClassDTO();
        classDTO.setId(classObj.getId());
        classDTO.setName(classObj.getName());
        return classDTO;
    }

}
