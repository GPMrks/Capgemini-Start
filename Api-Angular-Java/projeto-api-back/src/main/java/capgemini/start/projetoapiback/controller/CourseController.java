package capgemini.start.projetoapiback.controller;

import capgemini.start.projetoapiback.model.Course;
import capgemini.start.projetoapiback.service.impl.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        List<Course> courses = courseService.getAll();
        return ResponseEntity.ok().body(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable String id) {
        Course course = courseService.getById(id);
        return ResponseEntity.ok().body(course);
    }

    @PostMapping
    public ResponseEntity<Course> save(@RequestBody Course course) {
        Course courseToSave = courseService.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable String id, @RequestBody Course course) {
        Course courseToUpdate = courseService.update(id, course);
        return ResponseEntity.ok().body(course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
