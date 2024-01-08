import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ListSuiteComponent } from './suites/list-suite/list-suite.component';
import { DetailSuiteComponent } from './suites/detail-suite/detail-suite.component';
import { ProjectComponent } from './project/project.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatDialogModule } from '@angular/material/dialog';
import { NgChartsModule } from 'ng2-charts';
import { DetailProjectComponent } from './project/detail-project/detail-project.component';
import { RouterModule, Routes } from '@angular/router';

const appRouter : Routes = [
  {
      path : '',
      component: ProjectComponent
  },
  {
      path : 'project/:id',
      component: DetailProjectComponent
  },
  {
      // khi một router nào được gọi mà không có trong phần appRouter thì NotFoundComponent được gọi ra
      path : '**',  
      component: AppComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    ListSuiteComponent,
    DetailSuiteComponent,
    ProjectComponent,
    DetailProjectComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule, 
    MatButtonModule,  
    MatFormFieldModule, 
    MatInputModule, 
    BrowserAnimationsModule, 
    MatDialogModule,
    NgChartsModule,
    RouterModule.forRoot(appRouter)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
