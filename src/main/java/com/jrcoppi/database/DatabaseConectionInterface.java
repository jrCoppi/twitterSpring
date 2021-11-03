package com.jrcoppi.database;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public interface DatabaseConectionInterface {
	public ArrayList<String> search(String sql,String[] campos);
	public boolean insert(String Dados, String sql);
	public boolean update(String Dados, String sql);
	public boolean delete(String id, String sql);
	public void insertMulti(String sql);
	public Integer getLastInsertId();
}
