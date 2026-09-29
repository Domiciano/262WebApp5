package edu.co.icesi.introspringboot.service.impl;

import edu.co.icesi.introspringboot.entity.Course;
import edu.co.icesi.introspringboot.entity.Professor;
import edu.co.icesi.introspringboot.repo.CourseRepository;
import edu.co.icesi.introspringboot.repo.EnrollmentRepository;
import edu.co.icesi.introspringboot.repo.ProfessorRepository;
import edu.co.icesi.introspringboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    @Transactional
    public void createCourseWithProfessor(
            Course course,
            Professor professor
    ) {
        professorRepository.save(professor);
        courseRepository.save(course);
    }

    @Override
    @Transactional
    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
        //Eliminar los enrollments asociados
        enrollmentRepository.deleteByCourse_Id(id);
    }

    @Override
    public Course createCourse(Course course) {
        if(courseRepository.existsByName(course.getName())) {
            throw new IllegalArgumentException("Course with name " + course.getName() + " already exists");
        }
        else if(professorRepository.findById(course.getProfessor().getId()).isEmpty()) {
            throw new IllegalStateException("Professor with id " + course.getProfessor().getId() + " does not exist");
        }
        else if(course.getName() == null){
            throw new IllegalStateException("Course name is null");
        }else {
            Course savedCourse = courseRepository.save(course);
            return savedCourse;
        }
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }


    @Override
    public Course getById(Integer id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()) {
            return course.get();
        }else{
            throw new RuntimeException("Course with id " + id + " does not exist");
        }
    }

}
