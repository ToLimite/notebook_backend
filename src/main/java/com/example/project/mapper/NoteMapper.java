package com.example.project.mapper;

import com.example.project.dto.NoteDTO;
import com.example.project.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Select("select id, text from notes where user_id = #{id}")
    List<NoteDTO> getNotesByUserId(Long id);
}
