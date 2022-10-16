package com.example.demo1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
// @RestController
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
        return "redirect:list";
    }
    
    @GetMapping("list")
    public String list(Model model){
        model.addAttribute("list",bService.list());
        model.addAttribute("count",bService.count());
        return "list";
    }
    
    @GetMapping("detail/{num}")
    public String detail(@PathVariable int num, Model model){
        model.addAttribute("board",bService.detail(num));
        return "detail";
    }
    
    @DeleteMapping("delete/{num}")
    @ResponseBody
    public String delete(@PathVariable int num){
        bService.delete(num);
        return "success";
    }
    
    @PutMapping("update")
    @ResponseBody
    public String update(@RequestBody BoardDTO boardDTO){
        System.out.println(boardDTO.getNum());
        bService.update(boardDTO);
        return "success";
    }
    
    @PostMapping("commentInsert")
    @ResponseBody
    public String commentInsert(@RequestBody CommentDTO comment){
        bService.commentInsert(comment);
        return "success";    
    }

    @GetMapping("commentList")
    @ResponseBody
    public List<CommentDTO> commentList(int bnum){
        System.out.println("aaa");
        return bService.commentList(bnum);
    }
}
