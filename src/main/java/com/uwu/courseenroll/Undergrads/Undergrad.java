package com.uwu.courseenroll.Undergrads;
import com.uwu.courseenroll.Courses.Course;
import com.uwu.courseenroll.Parent.Parents;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Undergrad {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long undId;
    private String firstname;
    private String lastname;
    private String regno;

    @ManyToMany
    @JoinTable(
            name = "Assign_Course",
            joinColumns = @JoinColumn(name = "undId"),
            inverseJoinColumns = @JoinColumn(name = "csId")
    )
    private Set<Course> courses = new HashSet<>();

    public Undergrad() {
    }

    public Undergrad(String firstname, String lastname, String regno, Set<Course> courses) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.regno = regno;
        this.courses = courses;
    }

    public Long getUndId() {
        return undId;
    }

    public void setUndId(Long undId) {
        this.undId = undId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id",referencedColumnName = "ID")
    private Parents parents;

    public Parents getParents() {
        return parents;
    }

    public void setParents(Parents parents) {
        this.parents = parents;
    }
}
