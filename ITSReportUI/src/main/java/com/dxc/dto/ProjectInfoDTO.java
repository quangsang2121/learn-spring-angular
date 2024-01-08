package com.dxc.dto;

import com.dxc.entity.ProjectInfoEntity;

import lombok.Data;

@Data
public class ProjectInfoDTO {

	private Long id;
	private String projectFullName;
	private String projectName;
	private String url;
	private int work;
	
	public ProjectInfoDTO mapper(ProjectInfoEntity entiry) {
		ProjectInfoDTO project = new ProjectInfoDTO();
		project.setId(entiry.getId());
		project.setProjectFullName(entiry.getProjectFullName());
		project.setProjectName(entiry.getProjectName());
		project.setUrl(entiry.getUrl());
		project.setWork(entiry.getWork());
		return project;
	}
}
