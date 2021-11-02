package com.jrcoppi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MysqlConection implements DatabaseConectionInterface {
    // JDBC driver name and database URL
    String JDBC_DRIVER;
    String DB_URL;

    //  Database credentials
    final String USER = "root";
    final String PASS = "root";
    Connection conn;
	    
    private MysqlConection(){
        JDBC_DRIVER = "";
        DB_URL = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            JDBC_DRIVER = "com.mysql.jdbc.Driver";
            DB_URL  = "jdbc:mysql://localhost/twittermining";
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	    

	@Override
	public ArrayList<String> search(String sql, String[] campos) {
        ArrayList<String> resultado = new ArrayList<String>();
        
        try {
        	System.out.println(sql);
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                for (String campo : campos) {
                	resultado.add(rs.getString(campo));
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
        return resultado;
	}
	
	@Override
	public boolean insert(String Dados, String sql){
		String[] parts = Dados.split(";");
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            for (int i = 0; i < parts.length; i++) {
                stmt.setString(i+1,parts[i]);
            }
            
            stmt.execute();
            stmt.close();
        } catch (Exception ex) {
            System.out.println(sql);
            ex.printStackTrace();
            return false;
        }

        return true;
	}
	
	public void insertMulti(String sql){
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            stmt.execute();
            stmt.close();
        } catch (Exception ex) {
            System.out.println(sql);
            ex.printStackTrace();
        }
    }
	
	@Override
	public Integer getLastInsertId(){
        Integer retorno = null;
        try {
            PreparedStatement stmt = this.conn.prepareStatement("SELECT LAST_INSERT_ID() as retorno;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                retorno = Integer.valueOf(rs.getString("retorno"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return retorno;
    }


	@Override
	public void update(String Dados, String sql) {
		String[] parts = Dados.split(";");
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            for (int i = 0; i < parts.length; i++) {
                stmt.setString(i+1,parts[i]);
            }
            
            stmt.execute();
            stmt.close();
        } catch (Exception ex) {
            System.out.println(sql);
            System.out.println(Dados);
            ex.printStackTrace();
        }
	}


	@Override
	public void delete(String id, String sql) {
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.execute();
            stmt.close();
        } catch (Exception ex) {
            System.out.println(sql);
            ex.printStackTrace();
        }
	}

}
