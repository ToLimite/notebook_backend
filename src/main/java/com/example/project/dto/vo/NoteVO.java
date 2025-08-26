package com.example.project.dto.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteVO {
    public Long id;
    public String text;
    public Long index;
}
