package net.ict.springex.controller;

import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {
       /* @RequestMapping("/list")  //최종 경로는: /todo/list
        public void list(){
            log.info("todo list.................");
            }*/

    @RequestMapping("/list")
    public void list(Model model){
    log.info("todo list.................");
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register(){
        log.info("todo register..........");
    }


    //todo/register (기록 저장의 의미) 를 POST방식으로 처리하는 메소드()TOdoDTO 파라미터로 적용
    @PostMapping("/register")
    public String registerPost(TodoDTO todoDTO, RedirectAttributes redirectAttributes){ // ()안에 TodoDTO 적용해 전달
        log.info("POST todo register.........");
        log.info(todoDTO);
            return "redirect:/todo/list";

        }

}
