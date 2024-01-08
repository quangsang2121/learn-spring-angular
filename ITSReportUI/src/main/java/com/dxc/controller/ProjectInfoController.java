package com.dxc.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dxc.dto.ProjectInfoDTO;
import com.dxc.entity.ProjectInfoEntity;
import com.dxc.service.ProjectInfoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProjectInfoController {

	@Autowired
	ProjectInfoService projectInfoService;
	
	@GetMapping("/projects")
	public ResponseEntity<List<ProjectInfoEntity>> getProjects() {
		
		return ResponseEntity.status(HttpStatus.OK).
				body(projectInfoService.findAll());
	}
	
	@GetMapping("/projects/{id}")
	public ResponseEntity<ProjectInfoEntity>  getProjectById(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).
					body(projectInfoService.findById(id)) ;
		} catch(NoSuchElementException e) {
			throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Id Project Not Found");
		}
		
	}
	
	@PutMapping("/projects")
	public ResponseEntity<ProjectInfoEntity> updateProjectById(@RequestBody ProjectInfoDTO project) {
		
		try {
			ResponseEntity.status(HttpStatus.OK).
					body(projectInfoService.findById(project.getId())) ;
		} catch(NoSuchElementException e) {
			throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Id Project Not Found");
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(projectInfoService.updateProjectById(project));
	}
	
	@PostMapping("/projects")
	public ResponseEntity<List<ProjectInfoEntity>> createProject(@RequestBody ProjectInfoDTO project) {
		
		
		ProjectInfoEntity projectInfo = new ProjectInfoEntity();
		projectInfo.setProjectFullName( project.getProjectFullName());
		projectInfo.setProjectName(project.getProjectName()) ;
		projectInfo.setUrl( project.getUrl());
		//List<ProjectInfoEntity> list = projectInfoService.createProject(projectInfo);
		//ResponseEntity<List<ProjectInfoEntity>> res = restTemplate.exchange(getUrl(), HttpMethod.POST, myDTO, new ParameterizedTypeReference<List<MyObj>>() {});

		return null;
	}
}
