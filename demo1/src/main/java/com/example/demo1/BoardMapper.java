package com.example.demo1;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

    @Insert("insert into board(title,content) values(#{title},#{content})")
    public void insert(BoardDTO boardDTO);
    
}
