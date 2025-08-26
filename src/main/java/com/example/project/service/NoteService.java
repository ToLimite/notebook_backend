package com.example.project.service;

import com.example.project.dto.NoteDTO;

import java.util.ArrayList;
import java.util.List;

public interface NoteService {
    List<NoteDTO> getNotes(Long id);
}
