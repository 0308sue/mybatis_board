package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
   
    @Autowired
    private BoardMapper bMapper;

    public void insert(BoardDTO boardDTO) {
        bMapper.insert(boardDTO);
    }

}
