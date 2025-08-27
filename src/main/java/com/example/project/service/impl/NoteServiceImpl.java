package com.example.project.service.impl;

import com.example.project.dto.NoteDTO;
import com.example.project.dto.SaveDTO;
import com.example.project.mapper.NoteMapper;
import com.example.project.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteMapper noteMapper;

    @Override
    public List<NoteDTO> getNotes(Long id) {
        return noteMapper.getNotesByUserId(id);
    }

    @Override
    public void saveNotes(SaveDTO pyLoad) {
        Long id = pyLoad.getId();
        String text = pyLoad.getText();
        noteMapper.save(id, text);
    }
}
