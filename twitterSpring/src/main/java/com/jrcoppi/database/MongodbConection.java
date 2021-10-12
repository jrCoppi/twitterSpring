package com.jrcoppi.database;

import org.springframework.stereotype.Component;

@Component
public class MongodbConection implements DatabaseConectionInterface {

	@Override
	public String search(String query) {
		return "Mongo";
	}

}
