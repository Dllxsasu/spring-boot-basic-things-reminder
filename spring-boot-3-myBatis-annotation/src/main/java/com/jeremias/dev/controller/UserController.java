package com.jeremias.dev.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeremias.dev.mapper.UserMapper;
import com.jeremias.dev.modelos.User;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {


	private final UserMapper userMapper;
	
	@GetMapping
	public List<User> getUsers() {
		List<User> users=userMapper.getAll();
		return users;
	}
	
	@GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
    	User user=userMapper.getOne(id);
        return user;
    }
    
    @PostMapping()
    public void save(@RequestBody User user) {
    	userMapper.insert(user);
    }
    
    @PutMapping
    public void update(@RequestBody User user) {
    	userMapper.update(user);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
    	userMapper.delete(id);
    }
}
