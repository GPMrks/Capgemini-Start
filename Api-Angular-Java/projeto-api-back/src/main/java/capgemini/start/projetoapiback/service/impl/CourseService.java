package capgemini.start.projetoapiback.service.impl;

import capgemini.start.projetoapiback.exception.CourseDoesNotExistsException;
import capgemini.start.projetoapiback.model.Course;
import capgemini.start.projetoapiback.repository.impl.CourseRepository;
import capgemini.start.projetoapiback.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Course> getAll() {
        return courseRepository.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Course getById(String id) {
        return checkIfCourseExists(id);
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public Course update(String id, Course course) {
        checkIfCourseExists(id);
        return courseRepository.update(id, course);
    }

    @Override
    @Transactional
    public void delete(String id) {
        checkIfCourseExists(id);
        courseRepository.delete(id);
    }

    private Course checkIfCourseExists(String id) {
        Optional<Course> optionalCourse = Optional.ofNullable(courseRepository.getById(id));
        final Course courseIndicated;
        if (optionalCourse.isPresent()) {
            courseIndicated = optionalCourse.get();
        } else {
            throw new CourseDoesNotExistsException(id);
        }
        return courseIndicated;
    }
}
