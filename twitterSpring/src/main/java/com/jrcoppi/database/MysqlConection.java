package com.jrcoppi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            DB_URL  = "jdbc:mysql://localhost/brandfeeling";
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	    

	@Override
	public String search(String sql) {
		String retorno = "";
        String retornoInt = "";
        String separador = "";
        String separadorInt = "";
        String[] campos = null;
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                for (String campo : campos) {
                    retornoInt += separador + rs.getString(campo);
                    separador =  ";";
                }
                retorno += separadorInt + retornoInt;
                separadorInt = "|";
            }
        } catch (Exception ex) {
            System.out.println(sql);
            System.out.println(campos);
        } 
        return retorno;
	}
	
	@Override
	public void insert(String Dados, String sql){
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

}
