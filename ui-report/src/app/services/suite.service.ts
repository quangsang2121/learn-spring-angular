import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Suite } from '../model/suite';

@Injectable({
  providedIn: 'root'
})
export class SuiteService {

  constructor(private http : HttpClient) { }

  loadSuite() {
    return this.http.get<Suite[]>("http://localhost:8080/suite");
  }

  loadSuiteByProjectId(id : number) {
    return this.http.get<Suite[]>("http://localhost:8080/suite/"+id);
  }

}
