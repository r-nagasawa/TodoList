package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Service.TodoService;
import entity.TodoList;


@Controller
@RequestMapping("/todos")

public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@GetMapping
	public String TodoList(Model model) {
		model.addAttribute("todos", todoService.findAll());
	    return "TodoList";
	}
	  
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
	    model.addAttribute("todo", todoService.findOne(id));
	    return "show";
	}
	  
	//status変更に関するController
	 @GetMapping("/change-status")
	 public String statusChange(Long id) {
		 todoService.changeTodo(id);
	     return "redirect:/todos";
	 }
	  
	 //タスク新規登録用
	  @GetMapping("new")
	  public String newTodo(@ModelAttribute("todo") TodoList todo, Model model) {
	    return "new";
	  }
	  
	  @PostMapping
	  public String create(@ModelAttribute("todo") @Validated TodoList todo, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	      return "new";
	    } else {
	    	todoService.save(todo);
	    	return "redirect:/todos";
	    }
	  }
}