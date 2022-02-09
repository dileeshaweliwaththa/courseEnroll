package com.uwu.courseenroll.Lectures;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Lecture {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long lecId;

    private String firstname;
    private String lastname;
    private String courses;

}
