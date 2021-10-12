package com.jrcoppi.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Conection {

	@Autowired
	private DatabaseConectionInterface Database;

	public String Search(String query) {
		String data = Database.search(query);

		System.out.println(data);
		return data;
	}
}
