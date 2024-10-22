package com.studentGrade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private  Integer id;
    private String name;
    private String no;
    private String des;
    private String times;
    private String teacher;
}
