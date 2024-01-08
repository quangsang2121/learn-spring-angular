package com.dxc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dxc.entity.Suite;

public interface SuiteRepo extends JpaRepository<Suite, String> {

	@Query(value = "SELECT * FROM Suite WHERE project_id = :project_id", nativeQuery = true)
	List<Suite> getListSuiteByProjectId(@Param("project_id") Long projectId);
}
