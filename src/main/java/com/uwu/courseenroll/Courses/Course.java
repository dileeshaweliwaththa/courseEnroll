package com.uwu.courseenroll.Courses;
import com.uwu.courseenroll.Lectures.Lecture;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long csId;
    private String csname;

    public Course() {
    }

    public Course(String csname) {
        this.csname = csname;
    }

    public Long getCsId() {
        return this.csId;
    }

    public void setCsId(Long csId) {
        this.csId = csId;
    }

    public String getCsname() {
        return this.csname;
    }

    public void setCsname(String csname) {
        this.csname = csname;
    }

    @ManyToOne
    @JoinColumn(name="lecture_id", referencedColumnName = "lecId")
    private Lecture lectassign;

    public Lecture getLectassign() {
        return lectassign;
    }

    public void setLectassign(Lecture lectassign) {
        this.lectassign = lectassign;
    }
}
