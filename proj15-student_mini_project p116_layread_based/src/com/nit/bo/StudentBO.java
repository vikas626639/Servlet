package com.nit.bo;

import lombok.Data;

@Data
public class StudentBO {
	private Integer no;
	private String name;
	private Integer mark1;
	private Integer mark2;
	private Integer mark3;
	private Integer total;
	private float persent;
	private String status;
}
