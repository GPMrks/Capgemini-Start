package capgemini.start.projetoapiback.repository;

import capgemini.start.projetoapiback.model.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseRepository {

    public String generateUUID();

    public List<Course> getAll();

    public Optional<Course> getById(String id);

    public Course save(Course course);

    public Course update(String id, Course course);

    public void delete(String id);


}
