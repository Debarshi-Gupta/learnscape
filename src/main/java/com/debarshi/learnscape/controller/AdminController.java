package com.debarshi.learnscape.controller;

import com.debarshi.learnscape.model.Course;
import com.debarshi.learnscape.model.LearnscapeClass;
import com.debarshi.learnscape.model.Person;
import com.debarshi.learnscape.repository.CourseRepository;
import com.debarshi.learnscape.repository.LearnscapeClassRepository;
import com.debarshi.learnscape.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    LearnscapeClassRepository learnscapeClassRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    CourseRepository courseRepository;

    @RequestMapping("/displayClasses")
    public ModelAndView displayClasses(Model model) {
        List<LearnscapeClass> learnscapeClasses = learnscapeClassRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("classes.html");
        modelAndView.addObject("learnscapeClasses",learnscapeClasses);
        modelAndView.addObject("learnscapeClass", new LearnscapeClass());
        return modelAndView;
    }

    @PostMapping("/addNewClass")
    public ModelAndView addNewClass(Model model, @ModelAttribute("learnscapeClass") LearnscapeClass learnscapeClass) {
        learnscapeClassRepository.save(learnscapeClass);
        return new ModelAndView("redirect:/admin/displayClasses");
    }

    @RequestMapping("/deleteClass")
    public ModelAndView deleteClass(Model model, @RequestParam int id) {
        Optional<LearnscapeClass> learnscapeClass = learnscapeClassRepository.findById(id);
        for(Person person : learnscapeClass.get().getPersons()){
            person.setLearnscapeClass(null);
            personRepository.save(person);
        }
        learnscapeClassRepository.deleteById(id);
        return new ModelAndView("redirect:/admin/displayClasses");
    }

    @GetMapping("/displayStudents")
    public ModelAndView displayStudents(Model model, @RequestParam int classId, HttpSession session,
                                        @RequestParam(value = "error", required = false) String error) {
        String errorMessage = null;
        ModelAndView modelAndView = new ModelAndView("students.html");
        Optional<LearnscapeClass> learnscapeClass = learnscapeClassRepository.findById(classId);
        modelAndView.addObject("learnscapeClass",learnscapeClass.get());
        modelAndView.addObject("person",new Person());
        session.setAttribute("learnscapeClass",learnscapeClass.get());
        if(error != null) {
            errorMessage = "Invalid Email entered!!";
            modelAndView.addObject("errorMessage", errorMessage);
        }
        return modelAndView;
    }

    @PostMapping("/addStudent")
    public ModelAndView addStudent(Model model, @ModelAttribute("person") Person person, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        LearnscapeClass learnscapeClass = (LearnscapeClass) session.getAttribute("learnscapeClass");
        Person personEntity = personRepository.readByEmail(person.getEmail());
        if(personEntity==null || !(personEntity.getPersonId()>0)){
            modelAndView.setViewName("redirect:/admin/displayStudents?classId="+learnscapeClass.getClassId()
                    +"&error=true");
            return modelAndView;
        }
        personEntity.setLearnscapeClass(learnscapeClass);
        personRepository.save(personEntity);
        learnscapeClass.getPersons().add(personEntity);
        learnscapeClassRepository.save(learnscapeClass);
        modelAndView.setViewName("redirect:/admin/displayStudents?classId="+learnscapeClass.getClassId());
        return modelAndView;
    }

    @GetMapping("/deleteStudent")
    public ModelAndView deleteStudent(Model model, @RequestParam int personId, HttpSession session) {
        LearnscapeClass learnscapeClass = (LearnscapeClass) session.getAttribute("learnscapeClass");
        Optional<Person> person = personRepository.findById(personId);
        person.get().setLearnscapeClass(null);
        learnscapeClass.getPersons().remove(person.get());
        LearnscapeClass learnscapeClassSaved = learnscapeClassRepository.save(learnscapeClass);
        session.setAttribute("learnscapeClass",learnscapeClassSaved);
        return new ModelAndView("redirect:/admin/displayStudents?classId="+learnscapeClass.getClassId());
    }

    @GetMapping("/displayCourses")
    public ModelAndView displayCourses(Model model) {
        List<Course> courses = courseRepository.findAll(Sort.by("name").descending());
        ModelAndView modelAndView = new ModelAndView("courses_secure.html");
        modelAndView.addObject("courses",courses);
        modelAndView.addObject("course", new Course());
        return modelAndView;
    }

    @PostMapping("/addNewCourse")
    public ModelAndView addNewCourse(Model model, @ModelAttribute("course") Course course) {
        ModelAndView modelAndView = new ModelAndView();
        courseRepository.save(course);
        modelAndView.setViewName("redirect:/admin/displayCourses");
        return modelAndView;
    }

    @GetMapping("/viewStudents")
    public ModelAndView viewStudents(Model model, @RequestParam int id
            ,HttpSession session,@RequestParam(required = false) String error) {
        String errorMessage = null;
        ModelAndView modelAndView = new ModelAndView("course_students.html");
        Optional<Course> courses = courseRepository.findById(id);
        modelAndView.addObject("courses",courses.get());
        modelAndView.addObject("person",new Person());
        session.setAttribute("courses",courses.get());
        if(error != null) {
            errorMessage = "Invalid Email entered!!";
            modelAndView.addObject("errorMessage", errorMessage);
        }
        return modelAndView;
    }

    @PostMapping("/addStudentToCourse")
    public ModelAndView addStudentToCourse(Model model, @ModelAttribute("person") Person person,
                                           HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Course courses = (Course) session.getAttribute("courses");
        Person personEntity = personRepository.readByEmail(person.getEmail());
        if(personEntity==null || !(personEntity.getPersonId()>0)){
            modelAndView.setViewName("redirect:/admin/viewStudents?id="+courses.getCourseId()
                    +"&error=true");
            return modelAndView;
        }
        personEntity.getCourses().add(courses);
        courses.getPersons().add(personEntity);
        personRepository.save(personEntity);
        session.setAttribute("courses",courses);
        modelAndView.setViewName("redirect:/admin/viewStudents?id="+courses.getCourseId());
        return modelAndView;
    }

    @GetMapping("/deleteStudentFromCourse")
    public ModelAndView deleteStudentFromCourse(Model model, @RequestParam int personId,
                                                HttpSession session) {
        Course courses = (Course) session.getAttribute("courses");
        Optional<Person> person = personRepository.findById(personId);
        person.get().getCourses().remove(courses);
        courses.getPersons().remove(person);
        personRepository.save(person.get());
        session.setAttribute("courses",courses);
        return new
                ModelAndView("redirect:/admin/viewStudents?id="+courses.getCourseId());
    }

}