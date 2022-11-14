package net.ict.springex.controller;

import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController { //기본생성자
    @GetMapping("/hello") //get방식 매핑
    public void hello() {
        log.info("hello.............");
    }

    @GetMapping("/ex1") //파라미터를 받아서 생성
    public void ex1(String name, int age) {
        log.info("ex1.............");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex2") //파라미터를 받아오지 못할 때 기본 디폴트 값을 지정해 주는 것
    public void ex2(@RequestParam(name = "name", defaultValue = "AAA") String name, @RequestParam(name = "age", defaultValue = "20") int age) {
        log.info("ex2..........");
        log.info("name:" + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        log.info("ex3..........");
        log.info("dueDate:" + dueDate);

    }

    @GetMapping("/ex4")
    public void ex4(Model model) {
        log.info("Model info..........");
        model.addAttribute("message", "Hello SpringMVC!"); //담아서 옮길 수 있는 뷰 필요
    }

    @GetMapping("/ex5")
    public void ex5(TodoDTO todoDTO, Model model) {
        log.info("Model TOdoDTO info..........");
        log.info(todoDTO);
    }

    @GetMapping("/ex6")
    public String ex6(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("name", "ABC");
        redirectAttributes.addFlashAttribute("result", "success");
        return "redirect:/ex7";

    }

    @GetMapping("/ex7") //사용자가 볼 뷰페이지를 준비해야 한다.
    public void ex7() {

    }

    @GetMapping("/ex8")
    public void ex8(String p1, int p2) {
        log.info("p1 -----" + p1);
        log.info("p2 -----" + p2);
    }
}

        
        
    

