package com.uwu.courseenroll.Courses;

import com.uwu.courseenroll.Undergrads.Undergrad;
import com.uwu.courseenroll.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;

    public void saveCourse(Course course) {
        courseRepo.save(course);
    }

    public List<Course> getCourses() {
        return courseRepo.findAll();
    }

    public Course getByCSId(Long csId) throws UserNotFoundException {
        Optional<Course> result = courseRepo.findById(csId);
        if (result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("No Course Exists with the Course ID" + csId);
    }

    public void deleteByCSId(Long csId) {
        courseRepo.deleteById(csId);
    }
}
