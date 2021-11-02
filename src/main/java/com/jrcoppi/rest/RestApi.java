package com.jrcoppi.rest;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jrcoppi.database.Post;

//Controller
@RestController
public class RestApi {
	
	@Autowired
	private Post post;

	@GetMapping(path = "/pesquisa/{marca}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<String> pesquisar(@PathVariable String marca) {
		return this.post.getPesquisa(marca);
	}
	
	@PostMapping(path = "/post",produces = MediaType.APPLICATION_JSON_VALUE)
	public LinkedHashMap<String, Boolean> salvarPost(@RequestBody Map<String, Object> payload) {
		LinkedHashMap<String, Boolean> resultado = new LinkedHashMap<String, Boolean>(); 
		
		if(payload.get("post") == null) {
			resultado.put("sucesso", false);
			return resultado;
		}
		
		resultado.put("sucesso", this.post.insertPost(payload.get("post").toString()));
		return resultado;
		
	}

}
