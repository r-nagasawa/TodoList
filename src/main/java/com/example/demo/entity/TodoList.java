package com.example.demo.entity;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Date;

public class TodoList{
	private Long id;
	
	@NotBlank(message="Todoタイトルを記入してください。")
	private String task;

	private LocalDate date;
	
	private boolean status;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "TodoList [id=" + id + ", task=" + task + ", date=" + date + ", status=" + status + "]";
	}
}