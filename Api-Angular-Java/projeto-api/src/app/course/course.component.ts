import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Course } from '../model/Course';
import { CourseService } from './course.service';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  courses!: Observable<Course[]>;

  course: Course = new Course();

  constructor(private courseService: CourseService) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
      this.courses = this.courseService.getAll();
    }

  saveCourse() {
    this.courseService.save(this.course).subscribe({
      next: (data) => console.log(data),
      error: (error) => console.error(error),
      complete: () => this.getAll() 
  });
    this.course = new Course();
    this.getAll();
  }

  deleteCourse(id: string) {
    this.courseService.delete(id).subscribe({
      next: (data) => console.log(data),
      error: (error) => console.error(error),
      complete: () => this.getAll()
  });
  }

  selectCourse(course: Course) {
    this.course.id = course.id;
    this.course.name = course.name;
    this.course.value = course.value;
  }

  updateCourse() {
    this.courseService.update(this.course.id, this.course).subscribe({
      next: (data) => console.log(data),
      error: (error) => console.error(error),
      complete: () => this.getAll()
  });
  this.course = new Course();
  this.getAll();  
  }

}
