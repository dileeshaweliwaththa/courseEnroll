package com.uwu.courseenroll.Undergrads;

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
public class undergradController {

    @Autowired
    UndergradService undergradService;

    @GetMapping("/underg")
    public String showUndergrads(Model model){
        List<Undergrad> listUndergrad = undergradService.getUndergrads();
        model.addAttribute("listUndergrad", listUndergrad);
        model.addAttribute("undergrad2",new Undergrad());
        model.addAttribute("pageTitle", "Add New User");
        return "underg";
    }

//    @GetMapping("/underg/new")
//    public String showNewForm(Model model){
//        model.addAttribute("undergrad2",new Undergrad());
//        model.addAttribute("pageTitle", "Add New User");
//        return "underg";
//    }

    @PostMapping("/underg/save")
    public String saveUndergrads(Undergrad undergrad, RedirectAttributes ra){
        undergradService.saveUndergrad(undergrad);
        ra.addFlashAttribute("message", "User Added Successfully");
        return "redirect:/underg";
    }

    @GetMapping("/underg/edit/{undId}")
    public String showEditForm(@PathVariable("undId") Long undId, Model model, RedirectAttributes ra){
        try{
            Undergrad undergrad = undergradService.getById(undId);
            model.addAttribute("undergrad", undergrad);
            model.addAttribute("pageTitle", "Edit User (ID: "+ undId +")");
            return "undergform";
        }catch (UserNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/underg";
        }

    }


    @GetMapping("/underg/delet/{undId}")
    public String deleteUndId(@PathVariable("undId") Long undId, RedirectAttributes ra){
            undergradService.deleteByEmpId(undId);
            ra.addFlashAttribute("message","The User ID " + undId + " Deleted Succesfully");
        return "redirect:/underg";

    }



}
