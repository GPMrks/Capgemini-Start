package capgemini.start.projetoapiback.service;

import capgemini.start.projetoapiback.model.Course;

import java.util.List;

public interface ICourseService {

    public List<Course> getAll();

    public Course getById(String id);

    public Course save(Course course);

    public Course update(String id, Course course);

    public void delete(String id);

}
