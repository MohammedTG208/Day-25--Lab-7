package com.example.lab7week5.Controller;

import com.example.lab7week5.Model.Course;
import com.example.lab7week5.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/getall")
    public ResponseEntity GetAllCourses() {
        if (courseService.getAllCourses()==null) {
            return ResponseEntity.status(400).body("No courses yet");
        }else {
            return ResponseEntity.status(200).body(courseService.getAllCourses());
        }
    }

    @PostMapping("/add")
    public ResponseEntity AddCourse(@Valid @RequestBody Course course, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }else {
            courseService.addCourse(course);
            return ResponseEntity.status(201).body("Course added successfully");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity UpdateCourse(@Valid @RequestBody Course course, @PathVariable int id) {
        if (courseService.updateCourse(course, id)) {
            return ResponseEntity.status(201).body("Course updated successfully");
        }else {
            return ResponseEntity.status(404).body("Course not found with id " + id);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteCourse(@PathVariable int id) {
        if (courseService.removeCourse(id)){
            return ResponseEntity.status(201).body("Course deleted successfully");
        }else {
            return ResponseEntity.status(404).body("Course not found with id " + id);
        }
    }

    @GetMapping("/search/{byid}")
    public ResponseEntity SearchCourse(@PathVariable int byid) {
        if (courseService.searchById(byid)==null){
            return ResponseEntity.status(401).body("course not found with id " + byid);
        }else {
            return ResponseEntity.status(200).body(courseService.searchById(byid));
        }
    }

    @GetMapping("/get/isActive")
    public ResponseEntity GetCourseIsActive() {
        if (courseService.searchHowActive()==null){
            return ResponseEntity.status(201).body("there are not courses active yet ");
        }else {
            return ResponseEntity.status(200).body(courseService.searchHowActive());
        }
    }

    @GetMapping("/search/by/{name}")
    public ResponseEntity SearchCourseByName(@PathVariable String name) {
        if (courseService.searchByCourseName(name)==null){
            return ResponseEntity.status(400).body("there is not courses by this name");
        }else {
            return ResponseEntity.status(200).body(courseService.searchByCourseName(name));
        }
    }
    @PutMapping("/change/{id}/{value}")
    public ResponseEntity ChangeCourseValue(@PathVariable int id, @PathVariable boolean value) {
        if (courseService.changeActive(id,value)){
            return ResponseEntity.status(201).body("Course changed value successfully");
        }else {
            return ResponseEntity.status(404).body("Course not found with id " + id);
        }
    }

    @GetMapping("/search/by/name/{teacher}")
    public ResponseEntity SearchCourseByTeacher(@PathVariable String teacher) {
        if (courseService.searchByTeacher(teacher)==null){
            return ResponseEntity.status(400).body("there are not courses by this teacher");
        }else {
            return ResponseEntity.status(200).body(courseService.searchByTeacher(teacher));
        }
    }

}
