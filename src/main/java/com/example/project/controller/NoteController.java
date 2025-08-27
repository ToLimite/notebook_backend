package com.example.project.controller;

import com.example.project.common.Result;
import com.example.project.dto.NoteDTO;
import com.example.project.dto.SaveDTO;
import com.example.project.dto.vo.NoteVO;
import com.example.project.service.NoteService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/note")
public class NoteController {
    @Autowired
    private  NoteService noteService;

    @GetMapping("/{id}")
    public Result<List<NoteVO>> getNotes(@Valid @PathVariable Long id){

        List<NoteDTO> noteDTOList = noteService.getNotes(id);

        List<NoteVO> voList = new ArrayList<>();
        for(int i = 0; i < noteDTOList.size(); i ++){
            NoteVO t = new NoteVO();
            t.setId(noteDTOList.get(i).getId());
            t.setText(noteDTOList.get(i).getText());
            Long ii = (long) i;
            t.setIndex(ii);
            voList.add(t);
        }
        return Result.ok(voList);
    }

    @PostMapping("/save")
    public Result saveNotes(@Valid @RequestBody SaveDTO pyLoad){
        noteService.saveNotes(pyLoad);
        return Result.ok();
    }
}
