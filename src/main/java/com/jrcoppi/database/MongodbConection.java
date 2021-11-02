package com.jrcoppi.database;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class MongodbConection implements DatabaseConectionInterface {

	@Override
	public ArrayList<String> search(String sql,String[] campos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(String Dados, String sql) {
		return false;
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

	@Override
	public void update(String Dados, String sql) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id,String sql) {
		// TODO Auto-generated method stub
		
	}


}
