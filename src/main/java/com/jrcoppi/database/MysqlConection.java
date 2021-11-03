package com.jrcoppi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        PreparedStatement stmt = null;
        
		try {
			stmt = this.conn.prepareStatement(sql);
			for (int i = 0; i < parts.length; i++) {
                stmt.setString(i+1,parts[i]);
            }
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return this.execSql(stmt);
	}
	
	public void insertMulti(String sql){
        PreparedStatement stmt = null;
		try {
			stmt = this.conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        this.execSql(stmt);
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
	public boolean update(String Dados, String sql) {
		String[] parts = Dados.split(";");
        
		PreparedStatement stmt = null;
		try {
			stmt = this.conn.prepareStatement(sql);
            for (int i = 0; i < parts.length; i++) {
                stmt.setString(i+1,parts[i]);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
        return this.execSql(stmt);
	}


	@Override
	public boolean delete(String id, String sql) {
		PreparedStatement stmt = null;
		try {
			stmt = this.conn.prepareStatement(sql);
	        stmt.setString(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return this.execSql(stmt);
	}
	
	private boolean execSql(PreparedStatement stmt) {
		try {
            stmt.execute();
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
		
		return true;
	}

}
