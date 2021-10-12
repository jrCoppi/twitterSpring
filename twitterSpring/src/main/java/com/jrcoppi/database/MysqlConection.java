package com.jrcoppi.database;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MysqlConection implements DatabaseConectionInterface {

	@Override
	public String search(String query) {
		return "MYSQL";
	}

}
