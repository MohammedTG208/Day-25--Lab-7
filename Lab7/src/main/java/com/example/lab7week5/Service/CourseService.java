package com.example.lab7week5.Service;

import com.example.lab7week5.Model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {
    ArrayList<Course> courses = new ArrayList<Course>();

    public ArrayList<Course> getAllCourses() {
        return courses.isEmpty()?null:courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public boolean removeCourse(int id) {
        for (int i=0; i<courses.size(); i++) {
            if (courses.get(i).getId()==id){
                courses.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean updateCourse(Course course,int id) {
        for (int i=0; i<courses.size(); i++) {
            if (courses.get(i).getId()==id){
                courses.set(i,course);
                return true;
            }
        }
        return false;
    }


    public Course searchById(int id) {
        for (Course cours : courses) {
            if (cours.getId() == id) {
                return cours;
            }
        }
        return null;
    }

    public ArrayList<Course> searchHowActive( ) {
        ArrayList<Course> courses1=new ArrayList<>();
        for (int i=0; i<courses.size(); i++) {
            if (courses.get(i).isAvailable()){
                courses1.add(courses.get(i));
            }
        }
        return courses1.isEmpty()?null:courses1;
    }

    public Course searchByCourseName(String courseName) {
        for (int i=0; i<courses.size(); i++) {
            if (courses.get(i).getCourseName().equals(courseName)){
                return courses.get(i);
            }
        }
        return null;
    }

    public boolean changeActive(int id, boolean active) {
        for (int i=0; i<courses.size(); i++) {
            if (courses.get(i).getId()==id){
                courses.get(i).setAvailable(active);
                return true;
            }
        }
        return false;
    }

//    Extra method get all course by teacher name
    public ArrayList<Course> searchByTeacher(String teacherName) {
        ArrayList<Course> courses1=new ArrayList<>();
        for (int i=0; i<courses.size(); i++) {
            if (courses.get(i).getTeacher().equals(teacherName)){
                courses1.add(courses.get(i));
            }
        }
        return courses1.isEmpty()?null:courses1;
    }
}
