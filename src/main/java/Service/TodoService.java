package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import entity.TodoList;
import mapper.TodoMapper;

public class TodoService{
	@Autowired
	private static TodoMapper todoMapper;
	
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
	 public void changeTodo(Long id) {
		  TodoList todo = todoMapper.findOne(id);
		  Boolean todoStatus = todo.getStatus();
		  Boolean changeStatus = !todoStatus;
		  todo.setStatus(changeStatus);
		  todoMapper.save(todo);
	 }
}