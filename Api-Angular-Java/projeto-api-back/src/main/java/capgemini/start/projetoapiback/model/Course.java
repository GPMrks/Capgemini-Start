package capgemini.start.projetoapiback.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Course {

    @Id
    private String id;
    @Column(name = "courseName")
    private String name;
    @Column(name = "courseValue")
    private Double value;

    public Course() {
    }

    public Course(String id, String name, Double value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
