package com.jrcoppi.rest;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entity.Post;
import repository.PostRepository;



@RestController
public class RestApi {
	
	@Autowired
	private PostRepository postRepository;

	@GetMapping(path = "/pesquisa/{marca}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<String> pesquisar(@PathVariable String marca) {
		return  new ArrayList<String>();
	}
	
	//Inserts a new Post into the database
	@PostMapping(path = "/post",produces = MediaType.APPLICATION_JSON_VALUE)
	public LinkedHashMap<String, Boolean> salvarPost(@RequestBody Map<String, Object> payload) {
		LinkedHashMap<String, Boolean> resultado = new LinkedHashMap<String, Boolean>(); 
		
		if(payload.get("post") == null) {
			resultado.put("sucesso", false);
			return resultado;
		}
		
		Post newPost = new Post();
		newPost.setDsPost(payload.get("post").toString());
	    try {
			this.postRepository.save(newPost);
			resultado.put("sucesso", true);
		} catch (Exception e) {
			resultado.put("sucesso", false);
		}
		
		return resultado;
		
	}
	
	//Updates a current post
	@PutMapping(path = "/post/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public LinkedHashMap<String, Boolean> editarPost(@RequestBody Map<String, Object> payload, @PathVariable long id){
		LinkedHashMap<String, Boolean> resultado = new LinkedHashMap<String, Boolean>(); 
		
		if(payload.get("post") == null) {
			resultado.put("sucesso", false);
			return resultado;
		}
		
		Optional<Post> postEdit = this.postRepository.findById(id);
		
		if(!postEdit.isPresent()) {
			resultado.put("sucesso", false);
			return resultado;
		}
		
		postEdit.get().setDsPost(payload.get("post").toString());
		
		try {
			this.postRepository.save(postEdit.get());
			resultado.put("sucesso", true);
		} catch (Exception e) {
			resultado.put("sucesso", false);
		}
		
		return resultado;
	}
	
	//Removes a post from the database (if possible)
	@DeleteMapping(path = "/post/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public LinkedHashMap<String, Boolean> deletePost(@PathVariable long id){
		LinkedHashMap<String, Boolean> resultado = new LinkedHashMap<String, Boolean>(); 
		
		Optional<Post> postEdit = this.postRepository.findById(id);
		
		if(!postEdit.isPresent()) {
			resultado.put("sucesso", false);
			return resultado;
		}
		
		try {
			this.postRepository.delete(postEdit.get());
			resultado.put("sucesso", true);
		} catch (Exception e) {
			resultado.put("sucesso", false);
		}
		
		return resultado;
	}

}
