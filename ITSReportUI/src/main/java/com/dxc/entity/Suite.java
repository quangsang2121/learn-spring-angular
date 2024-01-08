package com.dxc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Suite {

	@Id
	private String suiteName;
	private String date;
	private String during;
	private String estimation;
	private String projectId;
	private String totalFail;
	private String totalPass;
}
