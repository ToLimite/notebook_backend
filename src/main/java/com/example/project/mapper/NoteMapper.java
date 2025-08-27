package com.example.project.mapper;

import com.example.project.dto.NoteDTO;
import com.example.project.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Select("select id, text from notes where user_id = #{id}")
    List<NoteDTO> getNotesByUserId(Long id);

    @Update("update notes set text = #{text} where id = #{id}")
    void save(Long id, String text);

    @Insert("insert into notes (text, user_id) values ('新建笔记', #{id})")
    void add(Long id);

    //    @Insert("insert into notes (text, user_id) values (#{text}, #{id})")
}
