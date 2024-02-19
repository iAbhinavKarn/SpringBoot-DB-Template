package com.abhinav.template.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateController {
	
	private final DataSource dataSource;

	@Autowired
	public TemplateController(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@PostMapping("/put")
	public void putData() {
		try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {
			statement.execute("CREATE TABLE Employee (" + "    EmpId int," + "    LastName varchar(255),"
					+ "    FirstName varchar(255)," + "    Address varchar(255)," + "    Department varchar(255),"
					+ "    City varchar(255));");

		} catch (Exception e) {
			// Handle exceptions appropriately
			e.printStackTrace();
		}

	}
}
