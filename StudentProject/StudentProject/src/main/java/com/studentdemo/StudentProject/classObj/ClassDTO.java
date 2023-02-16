package com.studentdemo.StudentProject.classObj;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClassDTO {

    private Long id;
    private String name;
}
