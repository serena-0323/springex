package net.ict.springex.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.PageRequestDTO;
import net.ict.springex.dto.TodoDTO;
import net.ict.springex.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor //생성자 주입을 위한 어노테이션
public class TodoController {
    
    private final TodoService todoService; //검증을 위한 인젝션
    
       @RequestMapping("/list")  //최종 경로는: /todo/list
        public void list(@Valid PageRequestDTO pageRequestDTO,BindingResult bindingResult, Model model){
            log.info("todo list.................");
            if(bindingResult.hasErrors()){
                pageRequestDTO = PageRequestDTO.builder().build();
            }
            model.addAttribute("responseDTO",todoService.getList(pageRequestDTO)); //결과 값을 모델에 담는다.
            }

    /*@RequestMapping("/list") //todo/list
    public void list(Model model) {
        
        log.info("todo list.................");
       model.addAttribute("dtoList",todoService.getAll()); //리스트 목록 데이터 가져오기
        //model(attributeName)에는 'dtoList'이름으로 목록데이터가 담겨있다.
    }
*/

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register() {
        log.info("todo register..........");
    }


    //todo/register (기록 저장의 의미) 를 POST방식으로 처리하는 메소드()TOdoDTO 파라미터로 적용
   /* @PostMapping("/register")
    public String registerPost(TodoDTO todoDTO, RedirectAttributes redirectAttributes){ // ()안에 TodoDTO 적용해 전달
        log.info("POST todo register.........");
        log.info(todoDTO);
            return "redirect:/todo/list";

        }*/
    @PostMapping("/register")
    public String registerPost(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) { //검증할 것이다. not empty 등등
        log.info("POST todo register.........");

        if(bindingResult.hasErrors()){
            log.error("has errors.........");
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors()); //에러가 있다면  todo/register로 돌아가라
            //일회성으로 돌아갈 예정이기때문에 addFlashAttribute를 사용한다.
            return "redirect:/todo/register"; //다시 돌아가 입력해라
        }

        log.info(todoDTO);
        todoService.register(todoDTO); //서비스에서 DTO를 register로 불러오기
        return "redirect:/todo/list";

    }


@GetMapping({"/read","/modify"})
    public void read(Long tno,Model model){

        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);
        model.addAttribute("dto",todoDTO);
}

@PostMapping("/remove")
    public String remove(Long tno, RedirectAttributes redirectAttributes){

        log.info("-------------remove-------------");
        log.info("tno:" +tno); //서버출력

        todoService.remove(tno);

        return "redirect:/todo/list";
}

@PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            log.info("--------has error-------");
                    redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
                    redirectAttributes.addAttribute("tno",todoDTO.getTno());
                    return  "redirect:/todo/modify";
        }
        log.info(todoDTO);
        todoService.modify(todoDTO);
        return "redirect:/todo/list";
}



}