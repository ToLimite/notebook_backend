package com.example.project.controller;

import com.example.project.common.Result;
import com.example.project.dto.LLMaskDTO;
import com.example.project.service.LLMService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/llm")
public class LLMController {
    @Autowired
    private LLMService llmService;

    @PostMapping("/ask")
    public Result askLLM(@Valid @RequestBody LLMaskDTO llmaskDTO){
        String text = llmaskDTO.getText();
        String res = llmService.askLLM(text);
        return Result.ok(res);
    }

}
