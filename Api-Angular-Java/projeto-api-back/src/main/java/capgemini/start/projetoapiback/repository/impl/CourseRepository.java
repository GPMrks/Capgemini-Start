package capgemini.start.projetoapiback.repository.impl;

import capgemini.start.projetoapiback.model.Course;
import capgemini.start.projetoapiback.repository.ICourseRepository;
import capgemini.start.projetoapiback.util.ConnectionFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CourseRepository implements ICourseRepository {

    @Override
    public String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    public List<Course> getAll() {

        String sql = "SELECT * FROM courses";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Course> courses = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Course course = new Course();
                course.setId(resultSet.getString("idCourse"));
                course.setName(resultSet.getString("courseName"));
                course.setValue(resultSet.getDouble("courseValue"));

                courses.add(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error when getting the courses!" + e.getMessage() + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        return courses;
    }

    @Override
    public Optional<Course> getById(String id) {

        String sql = "SELECT * FROM courses WHERE idCourse = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Course course = new Course();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                course.setId(resultSet.getString("idCourse"));
                course.setName(resultSet.getString("courseName"));
                course.setValue(resultSet.getDouble("courseValue"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error when getting course" + e.getMessage() + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        if (course.getName() != null) {
            return Optional.of(course);
        } else {
            return Optional.empty();
        }

    }

    @Override
    public Course save(Course course) {

        String sql = "INSERT INTO courses (idCourse ,courseName, courseValue) VALUES (?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, course.setId(generateUUID().substring(0, 5)));
            statement.setString(2, course.getName());
            statement.setDouble(3, course.getValue());
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Error when saving course" + e.getMessage() + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

        return course;
    }

    @Override
    public Course update(String id, Course course) {

        String sql = "UPDATE courses SET courseName = ?, courseValue = ? WHERE idCourse = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        Course courseUpdated;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, course.getName());
            statement.setDouble(2, course.getValue());
            statement.setString(3, id);
            statement.execute();
            courseUpdated = new Course();
            courseUpdated.setId(id);
            courseUpdated.setName(course.getName());
            courseUpdated.setValue(course.getValue());
        } catch (Exception e) {
            throw new RuntimeException("Error when updating course" + e.getMessage() + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        return courseUpdated;
    }

    @Override
    public void delete(String id) {

        String sql = "DELETE FROM courses WHERE idCourse = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Error when deleting course" + e.getMessage() + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }
}
