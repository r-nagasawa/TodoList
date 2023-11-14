package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.TodoList;

@Mapper
public interface TodoMapper{
	List<TodoList> findAll();
	
	TodoList findOne(Long id);
	
	void save(TodoList todo);
	
	void update(TodoList todo);

	void delete(Long id);
}
