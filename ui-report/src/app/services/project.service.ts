import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Project } from '../model/project';
@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  postId: string;
  errorMessage: any;

  constructor(private http : HttpClient) {
    
   }

  loadProjects() {
    return this.http.get<Project[]>("http://localhost:8080/projects");
  }

  updateProject(project : Project) {
    //return this.http.put<Project>("http://localhost:8080/projects",project).subscribe(data => this.postId = data.id);;

    return this.http.put<Project>("http://localhost:8080/projects",project).subscribe(
      {
        next: data => {
            this.postId = data.id;
        },
        error: error => {
            this.errorMessage = error.message;
            console.error('There was an error!', error);
        }
    }
    );
  }

  createProject(project : any) {
    return this.http.post<Project>("http://localhost:8080/projects",project).subscribe(
      {
        next: data => {
            this.postId = data.id;
            alert("Success")
        },
        error: error => {
            this.errorMessage = error.message;
            console.error('There was an error!', error);
        }
    }
    );
  }

  getProjectNameById(id : number) {
    return this.http.get<Project>("http://localhost:8080/projects/"+id);
  }
}
