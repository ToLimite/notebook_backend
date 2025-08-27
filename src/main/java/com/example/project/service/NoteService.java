package com.example.project.service;

import com.example.project.dto.NoteDTO;
import com.example.project.dto.SaveDTO;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

public interface NoteService {
    List<NoteDTO> getNotes(Long id);

    void saveNotes(SaveDTO pyLoad);

    void addNotes(@Valid Long id);
}
