package com.luka.anirest.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.luka.anirest.model.User;

@FeignClient(name = "user", url = "http://localhost:6969/user")
public interface UserProxy {

	@GetMapping("/return/{id}")
	public User returnById(@PathVariable int id);
}