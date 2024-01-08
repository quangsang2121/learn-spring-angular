package com.dxc.service;

import java.util.List;

import com.dxc.dto.ProjectInfoDTO;
import com.dxc.entity.ProjectInfoEntity;


public interface ProjectInfoService {

	List<ProjectInfoEntity> findAll();
	
	ProjectInfoEntity findById(Long id );
	
	ProjectInfoEntity updateProjectById(ProjectInfoDTO project);
	
	List<ProjectInfoEntity> createProject(ProjectInfoDTO project);
}
