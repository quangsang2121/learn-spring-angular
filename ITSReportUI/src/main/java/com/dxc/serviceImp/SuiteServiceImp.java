package com.dxc.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxc.entity.Suite;
import com.dxc.repository.SuiteRepo;
import com.dxc.service.SuiteService;

@Component
public class SuiteServiceImp implements SuiteService{

	@Autowired
	SuiteRepo suiteRepo;
	
	@Override
	public List<Suite> getListResultTestSuites() {
		// TODO Auto-generated method stub
		return suiteRepo.findAll();
	}

	@Override
	public List<Suite> getListSuiteByProjectId(Long id) {
		// TODO Auto-generated method stub
		
		return suiteRepo.getListSuiteByProjectId(id);
	}


}
