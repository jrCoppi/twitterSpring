package com.jrcoppi.database;

import org.springframework.stereotype.Component;

@Component
public interface DatabaseConectionInterface {
	public String search(String sql);
	public void insert(String Dados, String sql);
	public void insertMulti(String sql);
	public Integer getLastInsertId();
}
