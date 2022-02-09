package com.uwu.courseenroll.Courses;


import com.uwu.courseenroll.Lectures.LectureService;
import com.uwu.courseenroll.Undergrads.Undergrad;
import com.uwu.courseenroll.Undergrads.UndergradService;
import com.uwu.courseenroll.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.List;

@Controller
public class courseController {

    @Autowired
    CourseService courseService;

    @Autowired
    UndergradService undergradService;

    @Autowired
    LectureService lectureService;

    @GetMapping("/cours")
    public String showUndergrads(Model model){
        List<Course> listCourses = courseService.getCourses();
        model.addAttribute("listCourses", listCourses);
        model.addAttribute("course2",new Course());
        model.addAttribute("pageTitle", "Add New Course");
        model.addAttribute("allLects",lectureService.getLectures());
        return "cours";
    }

    @PostMapping("/cours/save")
    public String saveCourse(Course course, RedirectAttributes ra){
        courseService.saveCourse(course);
        ra.addFlashAttribute("message", "Course Added Successfully");
        return "redirect:/cours";
    }

    @GetMapping("/cours/assign/{undId}")
    public String assCourse(@PathVariable("undId") Long undId, Model model, RedirectAttributes ra){
        try{
            Undergrad undergrad = undergradService.getById(undId);
            model.addAttribute("undergrad", undergrad);
            model.addAttribute("allcourses", courseService.getCourses());
//            model.addAttribute("pageTitle", "Edit User (ID: "+ undId +")");
            return "assignCours";
        }catch (UserNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/underg";
        }

    }

    @PostMapping("/cours/assign/confirm")
    public String confirmAss(Undergrad undergrad, RedirectAttributes ra){
        try {
            Undergrad undergrad1 = undergradService.getById(undergrad.getUndId());
            undergrad1.setCourses(undergrad.getCourses());
            undergradService.saveUndergrad(undergrad1);
            ra.addFlashAttribute("message", "Course Added Successfully");
            return "redirect:/underg";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/underg";
        }

    }

    @GetMapping("/cours/edit/{csId}")
    public String showCSEditForm(@PathVariable("csId") Long csId, Model model, RedirectAttributes ra){
        try{
            Course course = courseService.getByCSId(csId);
            model.addAttribute("course", course);
            model.addAttribute("pageTitle", "Edit Course (ID: "+ csId +")");
            return "coursForm";
        }catch (UserNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/cours";
        }
    }

    @GetMapping("/cours/delet/{csId}")
    public String deleteCSId(@PathVariable("csId") Long csId, RedirectAttributes ra){
        courseService.deleteByCSId(csId);
        ra.addFlashAttribute("message","The Course ID " + csId + " Deleted Succesfully");
        return "redirect:/cours";
    }
}
