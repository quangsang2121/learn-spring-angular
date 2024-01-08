import { Component, Input, OnInit, ViewChild } from '@angular/core';
import Chart from 'chart.js/auto';
import { Observable, first } from 'rxjs';
import { Suite } from 'src/app/model/suite';
import { SuiteService } from 'src/app/services/suite.service';
import { ProjectComponent } from '../project.component';
import { ActivatedRoute, Router } from '@angular/router';
import { ProjectService } from 'src/app/services/project.service';
import { Project } from 'src/app/model/project';


@Component({
  selector: 'app-detail-project',
  templateUrl: './detail-project.component.html',
  styleUrls: ['./detail-project.component.css']
})
export class DetailProjectComponent implements OnInit{

  data: Project;
  projectId: number;
  projectName : string ;
  suites$ : Observable<Suite[]>;;
  constructor(private suiteService : SuiteService ,private route: ActivatedRoute ,private router: Router,
    private projectService : ProjectService) {
    const id= +this.route.snapshot.params['id'];
    this.projectId = id;
    console.log(this.projectId)
    this.suites$ = this.suiteService.loadSuiteByProjectId(id);
    this.projectService.getProjectNameById(id).subscribe(val => {this.projectName = val.projectFullName})
    console.log(this.projectService.getProjectNameById(id).subscribe)
  }

  public chart: any;
  createChart(id : number){
    
    const data = {
      labels: [
        'Fail',
        'Pass',
        'Not run'
      ],
      datasets: [{
        label: 'Number',
        data: [300, 50, 100],
        backgroundColor: [
          'rgb(255, 0, 0)',
          'rgb(0, 255, 0)',
          'rgb(159 , 182 , 205)'
        ],
        hoverOffset: 8 ,
      }] ,
    }; 

    this.chart = new Chart("MyChart", {
      type: 'doughnut', //this denotes tha type of chart
      data :data ,
      
    });
  }

  ngOnInit(): void {
    console.log(this.data)
    this.createChart(this.projectId);

  }


}
