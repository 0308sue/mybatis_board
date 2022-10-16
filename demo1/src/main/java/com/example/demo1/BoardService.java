package com.example.demo1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
   
    @Autowired
    private BoardMapper bMapper;

    public void insert(BoardDTO boardDTO) {
        bMapper.insert(boardDTO);
    }

    public List<BoardDTO> list() {
        return bMapper.list();
    }

    public int count() {
        return bMapper.count();
    }

    public BoardDTO detail(int num) {
        return bMapper.detail(num);
    }

    public void delete(int num) {
        bMapper.delete(num);
    }

    public void update(BoardDTO boardDTO) {
        bMapper.update(boardDTO);
    }

    public void commentInsert(CommentDTO comment) {
        bMapper.commentInsert(comment);
    }

    public List<CommentDTO> commentList(int bnum) {
        return bMapper.commnetList(bnum);
    }

}
