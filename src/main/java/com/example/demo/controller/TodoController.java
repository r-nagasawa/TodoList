package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.TodoService;
import com.example.demo.entity.TodoList;

//コントローラーはイベントを受けて処理を呼び出す。
@Controller
@RequestMapping("/todos")

public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@GetMapping
	public String todoList(Model model) {
		model.addAttribute("todos", todoService.findAll());
	    return "todoList";
	}
	
	//該当するidのデータ
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
	    model.addAttribute("todo", todoService.findOne(id));
	    return "show";
	}
	  
	//status変更用Controller
	@PostMapping("stUpdate")
	 public String statusChange(Model model, @RequestParam("id") Long id) {
		 todoService.update(id);
		 model.addAttribute("click", true);
		 
	     return "redirect:/todos";
	 }
	//status戻し用
	@PostMapping("stBack")
	 public String statusBack(Model model, @RequestParam("id") Long id) {
		 todoService.back(id);
		 model.addAttribute("click", false);
		 
	     return "redirect:/todos";
	 }
	  
	 //タスク新規登録用
	  @GetMapping("new")
	  public String newTodo(Model model) {
			  model.addAttribute("todo", new TodoList());
			  return "new";
	  }
	  
	  @PostMapping("post")
	  public String create(@ModelAttribute("todo") @Validated TodoList todo, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	      return "new";
	    } else {
	    	todoService.save(todo);
	    	return "redirect:/todos";
	    }
	  }
	  
	  @PostMapping("delete/{id}") //DeleteMapping...削除に使えるアノテーション
	  public String delete(Model model, @RequestParam("id") Long id) {
		  todoService.delete(id);
	    return "redirect:/todos"; 
	  }
	  
	  //ソート用
	  /*@PostMapping("sort")
	  public void sort(@ModelAttribute("todo") @Validated TodoList todo, BindingResult result, Model model) {
		  
	  }*/
}