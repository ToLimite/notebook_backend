package com.example.project.controller;

import com.example.project.common.Result;
import com.example.project.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/note")
public class NoteController {
    @Autowired
    private  NoteService noteService;

    @GetMapping("/{id}")
    public Result getNotes(@Valid @PathVariable Long id){

        List list = noteService.getNotes(id);
        return Result.ok(list);
    }
}
