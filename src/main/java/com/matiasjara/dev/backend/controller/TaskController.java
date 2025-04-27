package com.matiasjara.dev.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matiasjara.dev.backend.Services.ITaskService;
import com.matiasjara.dev.backend.model.Task;

@RestController
@RequestMapping("/api/task")
public class TaskController {
  
    
    private final ITaskService service;
    
    public TaskController(ITaskService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/eisenhower/urgent-important")
    public ResponseEntity<List<Task>> getUrgentAndImportantTasks() {
        return new ResponseEntity<>(service.getUrgentAndImportantTasks(), HttpStatus.OK);
    }

    @GetMapping("/eisenhower/not-urgent-important")
    public ResponseEntity<List<Task>> getNotUrgentAndImportantTasks() {
        return new ResponseEntity<>(service.getNotUrgentAndImportantTasks(), HttpStatus.OK);
    }

    @GetMapping("/eisenhower/urgent-not-important")
    public ResponseEntity<List<Task>> getUrgentAndNotImportantTasks() {
        return new ResponseEntity<>(service.getUrgentAndNotImportantTasks(), HttpStatus.OK);
    }

    @GetMapping("/eisenhower/not-urgent-not-important")
    public ResponseEntity<List<Task>> getNotUrgentAndNotImportantTasks() {
        return new ResponseEntity<>(service.getNotUrgentAndNotImportantTasks(), HttpStatus.OK);
    }    
}
