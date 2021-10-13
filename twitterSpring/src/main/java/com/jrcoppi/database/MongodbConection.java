package com.jrcoppi.database;

import org.springframework.stereotype.Component;

@Component
public class MongodbConection implements DatabaseConectionInterface {

	@Override
	public String search(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(String Dados, String sql) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertMulti(String sql) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getLastInsertId() {
		// TODO Auto-generated method stub
		return null;
	}


}
