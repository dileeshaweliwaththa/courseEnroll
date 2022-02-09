package com.uwu.courseenroll.Lectures;

import com.uwu.courseenroll.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class lectureController {

    @Autowired
    LectureService lectureService;

    @GetMapping("/lect")
    public String showLectures(Model model){
        List<Lecture> listLecture = lectureService.getLectures();
        model.addAttribute("listLecture", listLecture);
        model.addAttribute("lecture2",new Lecture());
        model.addAttribute("pageTitle", "Add New Lecturer");
        return "lect";
    }

//    @GetMapping("/lect/new")
//    public String showNewForm(Model model){
//        model.addAttribute("lecture2",new Lecture());
//        model.addAttribute("pageTitle", "Add New User");
//        return "lect";
//    }

    @PostMapping("/lect/save")
    public String saveLectures(Lecture lecture, RedirectAttributes ra){
        lectureService.saveLecture(lecture);
        ra.addFlashAttribute("message", "Lecturer Saved Successfully");
        return "redirect:/lect";
    }

    @GetMapping("/lect/edit/{undId}")
    public String showEditForm(@PathVariable("undId") Long undId, Model model, RedirectAttributes ra){
        try{
            Lecture lecture = lectureService.getById(undId);
            model.addAttribute("lecture", lecture);
            model.addAttribute("pageTitle", "Edit Lecturer (ID: "+ undId +")");
            return "lectform";
        }catch (UserNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/lect";
        }

    }


    @GetMapping("/lect/delet/{undId}")
    public String deleteUndId(@PathVariable("undId") Long undId, RedirectAttributes ra){
        lectureService.deleteByEmpId(undId);
        ra.addFlashAttribute("message","The Lecturer ID " + undId + " Deleted Succesfully");
        return "redirect:/lect";

    }


}
