package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.TodoList;
import com.example.demo.mapper.TodoMapper;

@Service
public class TodoService{
	@Autowired
	private TodoMapper todoMapper;
	//↑private staticにすると、status=500エラー・・・todoMapper.findAll()がnullになる。
	
	@Transactional
	 public List<TodoList> findAll() {
		return todoMapper.findAll();
	  }
	
	@Transactional
	 public TodoList findOne(Long id) {
		return todoMapper.findOne(id);
	  }
	
	 @Transactional
	 public void save(TodoList todo) {
		 todoMapper.save(todo);
	  }
	 
	 //idを取得してtodoに代入、statusのtrue/falseをDBに保存
	 @Transactional
	 public void update(Long id) {
		 TodoList todo = findOne(id);
		 todo.setStatus(true);
		 todoMapper.update(todo);
	 }
}