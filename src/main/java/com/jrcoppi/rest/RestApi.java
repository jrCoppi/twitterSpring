package com.jrcoppi.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jrcoppi.database.Post;

//Controller
@RestController
public class RestApi {
	
	@Autowired
	private Post post;

	@GetMapping(path = "/pesquisa/{marca}")
	public String pesquisar(@PathVariable String marca) {
		return this.post.getPesquisa(marca);
	}

}
