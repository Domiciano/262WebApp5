package edu.co.icesi.introspringboot.controller;


import edu.co.icesi.introspringboot.entity.Professor;
import edu.co.icesi.introspringboot.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/new")
    public String newProfessor(Model model) {
        model.addAttribute(
                "professor",
                new Professor ()
        );
        return "professor/new";
    }

    @PostMapping
    public String createProfessor(){
        return "redirect:/professor/new";
    }

}
