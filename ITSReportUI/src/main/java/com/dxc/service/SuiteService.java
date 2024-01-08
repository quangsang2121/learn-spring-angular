package com.dxc.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dxc.entity.Suite;

@Component
public interface SuiteService {
	List<Suite> getListResultTestSuites();
	
	List<Suite> getListSuiteByProjectId(Long projectId);
}
