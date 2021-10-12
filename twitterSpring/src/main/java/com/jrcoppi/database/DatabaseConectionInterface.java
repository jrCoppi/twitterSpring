package com.jrcoppi.database;

import org.springframework.stereotype.Component;

@Component
public interface DatabaseConectionInterface {
	public String search(String query);
}
