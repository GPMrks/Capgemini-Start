import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Course } from '../model/Course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private url: String = "http://localhost:8080/courses";

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Course[]>{
    return this.httpClient.get<Course[]>(`${this.url}`);
  }

  save(course: Object): Observable<Object> {
    return this.httpClient.post<Course>(`${this.url}`, course);
  }

  delete(id: string): Observable<any>{
    return this.httpClient.delete(`${this.url}/${id}`, {responseType: "text"});
  }

  update(id: string, value: any) {
    return this.httpClient.put<Course>(`${this.url}/${id}`, value)
  }

}
