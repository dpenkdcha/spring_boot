package com.example.sb.basicspringboot.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    
    private List<Course> courses = new ArrayList<>();

    public List<Course> getAllCourses (String topicId) {
        //return ;
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id) {
        //return .stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id).get();
    }

	public void addCourse(Course course) {
        //.add(Course);
        courseRepository.save(course);
	}

	public void updateCourse(Course course) {
        /* for(int i=0; i < .size(); i++) {
            Course t = .get(i);
            if(t.getId().equals(id)) {
                .set(i, Course);
                return;
            }
        } */

        courseRepository.save(course);
    }

	public void deleteCourse(String id) {
        //.removeIf(t -> t.getId().equals(id));
        courseRepository.deleteById(id);
	}
}