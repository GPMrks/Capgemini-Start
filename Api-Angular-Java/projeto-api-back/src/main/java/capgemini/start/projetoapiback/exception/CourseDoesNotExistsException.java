package capgemini.start.projetoapiback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CourseDoesNotExistsException extends RuntimeException{
    public CourseDoesNotExistsException(String id) {
        super("Course not found with ID " + id);
    }

}
