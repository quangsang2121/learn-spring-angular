package com.dxc.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxc.dto.ProjectInfoDTO;
import com.dxc.entity.ProjectInfoEntity;
import com.dxc.repository.ProjectInfoRepo;
import com.dxc.service.ProjectInfoService;

@Component
public class ProjectInfoServiceImp implements ProjectInfoService{

	@Autowired
	ProjectInfoRepo projectInfoRepo;
		
	@Override
	public List<ProjectInfoEntity> findAll() {
		// TODO Auto-generated method stub
		
		return  projectInfoRepo.findAll() ;
	}

	@Override
	public ProjectInfoEntity findById(Long id) {
		// TODO Auto-generated method stub
		return projectInfoRepo.findById(id).get();
	}

	@Override
	public ProjectInfoEntity updateProjectById(ProjectInfoDTO project ) {
		// TODO Auto-generated method stub
		ProjectInfoEntity projectById = projectInfoRepo.findById(project.getId()).get();
		projectById.setProjectFullName(project.getProjectFullName());
		projectById.setProjectName(project.getProjectName());
		projectById.setUrl(project.getUrl());
		projectById.setWork(project.getWork());
		return projectInfoRepo.save(projectById);
		
		
	}

	@Override
	public List<ProjectInfoEntity> createProject(ProjectInfoDTO project) {
		// TODO Auto-generated method stub
//		
//		List<ProjectInfoEntity> listProject = projectInfoRepo.findAll();
//		
//		if (checkDuplicateProject(listProject , project)) {
//			return null;
//		} 
//		
//		projectInfoRepo.save(null)
//		return projectInfoRepo.findAll();
		return null;
		
		
		
	}

	
	private boolean checkDuplicateProject(List<ProjectInfoEntity> listProject , ProjectInfoDTO project) {
		
		long result = listProject.stream()
		.filter(x -> x.getProjectFullName().equalsIgnoreCase(project.getProjectFullName())
					&& x.getProjectName().equalsIgnoreCase(project.getProjectName())
					&& x.getUrl().equalsIgnoreCase(project.getUrl()))
		.count();
		return result > 0 ? true : false;
	}

}
