package edu.co.icesi.introspringboot.controller;


import edu.co.icesi.introspringboot.entity.Course;
import edu.co.icesi.introspringboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//Thymeleaf
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String index(Model model) {
        //Inyeccion de la información
        model.addAttribute(
                "title",
                "Lista de cursos");
        List<Course> courseList = courseService.getAll();
        model.addAttribute("courseList", courseList);
        return "course/index";
        //Retornamos un index.html que esta dentro de
        //resources/course/index.html
    }

    // http://localhost:8080/course/detail/1
    @GetMapping("/detail/{id}")
    public String getCourseById(Model model, @PathVariable Integer id) {
        //Obtener el curso con id 1
        Course course = courseService.getById(id);
        model.addAttribute(
                "course",
                course
        );
        return "course/detail";
    }


    //http://localhost:8080/course/detail2?id=1
    //Filtros
    @GetMapping("/detail2")
    public String getCourseById2(Model model, @RequestParam Integer id) {
        //Obtener el curso con id 1
        Course course = courseService.getById(id);
        model.addAttribute(
                "course",
                course
        );
        return "course/detail";
    }


}
