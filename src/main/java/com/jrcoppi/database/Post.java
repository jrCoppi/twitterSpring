package com.jrcoppi.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Post {

	@Autowired
	private DatabaseConectionInterface Database;
	
	public String getPesquisa(String termo){
        String sql = 
        		"SELECT po.ds_post "
        		+ "FROM pesquisa p "
        		+ "INNER JOIN pesquisa_post pp ON ( pp.id_pesquisa = p.id_pesquisa) "
        		+ "INNER JOIN termo t ON (t.id_termo = p.id_termo)"
        		+ "INNER JOIN post po ON ( pp.id_post = po.id_post) "
        		+ "WHERE t.ds_termo like '%" + termo + "%'";
        String[] campos = new String[1]; 
        
        campos[0] = "ds_post";
        
        String retorno = Database.search(sql,campos);
        
        return retorno;
    }
	
    public Integer insertPost(String post){
        String sql = "insert into post " +
            "(id_post,ds_post)" +
            " values (null,?)";
        
        String dados = post;
        
        //inserir
        Database.insert(dados, sql);
        
        //retorna o ultimo id
        return Database.getLastInsertId();
    }
    
    public void updatePost(String post,String id){
        String sql = "update post set ds_post =  ? where id_post = ?";
        
        String dados = post + ';' + id;
        
        //atualiza
        Database.update(dados, sql);
    }
    
    public void deletePost(String id){
        String sql = "DELETE FROM post where id_post = ?";
        
        String dados = id;
        
        //atualiza
        Database.delete(dados, sql);
    }
}
