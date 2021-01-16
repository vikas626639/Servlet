package com.nit.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class StudentDTO implements Serializable {
	private Integer no;
	private String name;
	private Integer mark1;
	private Integer mark2;
	private Integer mark3;
}
