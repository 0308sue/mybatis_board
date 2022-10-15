package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    
    @Autowired
    private BoardService bService;

    @GetMapping("/")
    public String home(){
        return "board";
    }

    @PostMapping("insert")
    public String insert(BoardDTO boardDTO){
        bService.insert(boardDTO);
        return "board";
    }
}
