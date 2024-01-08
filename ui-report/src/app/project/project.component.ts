import { Component, ElementRef, ViewChild } from '@angular/core';
import { Observable } from 'rxjs';
import { Project } from '../model/project';
import { ProjectService } from '../services/project.service';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent {

  isCreate : boolean = true;

  projectId  : number;

  
  projects$ : Observable<Project[]>;

  constructor( private projectService : ProjectService) {
    this.projects$ = this.projectService.loadProjects();
  }

  updateProject(id : string ,  projectName : string , projectFullName: string , url :string , work : string) {
    console.log(work);
    if(work == '0' || work == '1') {
      var project  = { id : id , projectName : projectName , projectFullName: projectFullName , url :url , work : work}
      if(confirm("Do you want update ?")) {
        console.log(this.projectService.updateProject(project));
        //this.reload();
      }
    } else {
      alert("format incorrect");
    } 
    
  }

  addForm() {
    this.isCreate = false;
  }

  addProject( projectName : string , projectFullName: string , url :string ) {
    var crProject  = { projectName : projectName , projectFullName: projectFullName , url :url}
    this.isCreate = true;
    this.projectService.createProject(crProject);
  }

  reload(){
    window.location.reload();
  }

  detailProject(id : string) {
    this.projectId = Number(id);
  }
}
