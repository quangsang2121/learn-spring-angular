package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.entity.Suite;
import com.dxc.service.SuiteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SuiteController {

	@Autowired
	SuiteService suiteService;
	
	@GetMapping("/suite")
	public List<Suite> getListResultTestSuite() {
		return suiteService.getListResultTestSuites();
	}
	
	@GetMapping("suite/{id}")
	public List<Suite> getListSuiteByProjectId(@PathVariable Long id) {
		return suiteService.getListSuiteByProjectId(id);
	}
}
