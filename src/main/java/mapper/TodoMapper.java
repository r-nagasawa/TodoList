package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import entity.TodoList;

@Mapper
public interface TodoMapper{
	List<TodoList> findAll();
	
	TodoList findOne(Long id);
	
	void save(TodoList todo);
	
	void changeTodo(Long id);
}
