package com.example.demo1;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BoardMapper {

    @Insert("insert into board(title,content) values(#{title},#{content})")
    public void insert(BoardDTO boardDTO);

    @Select("select * from board")
    public List<BoardDTO> list();

    @Select("select count(*) from board")
    public int count();

    @Select("select * from board where num = #{num}")
    public BoardDTO detail(int num);

    @Delete("delete from board where num = #{num}")
    public void delete(int num);

    @Update("update board set title = #{title},content = #{content} where num = #{num}")
    public void update(BoardDTO boardDTO);

    @Insert("insert into comment(bnum,comment) values(#{bnum},#{comment})")
    public void commentInsert(CommentDTO comment);

    @Select("select * from comment where bnum = #{bnum}")
    public List<CommentDTO> commnetList(int bnum);
    
}
