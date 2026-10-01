package edu.co.icesi.introspringboot.controller;


import edu.co.icesi.introspringboot.entity.Professor;
import edu.co.icesi.introspringboot.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/new")
    public String newProfessor(Model model,
                               @RequestParam(required = false) String status) {
        if(status != null) {
            if(status.equals("success")) {
                model.addAttribute("message",
                        "Professor successfully saved");
            }
        }
        model.addAttribute(
                "professor",
                new Professor ()
        );
        return "professor/new";
    }

    @PostMapping("/save")
    public String createProfessor(@ModelAttribute Professor professor) {
        professorService.save(professor);
        return "redirect:/professor/new?status=success ";
    }

}
