package net.ict.springex.service;

import net.ict.springex.dto.PageResponseDTO;
import net.ict.springex.dto.PageRequestDTO;
import net.ict.springex.dto.TodoDTO;

public interface TodoService { //등록서비스
    void register(TodoDTO todoDTO);
    //List<TodoDTO> getAll(); //리스트를 전부 가져오겠다. //페이징할때는 사용하지 않는다.

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageReuestDTO); //PageReuestDTO에 반환받겠다
    
    TodoDTO getOne(Long tno); //todoDTO를 받을 것이다.

    void remove(Long tno);

    void modify(TodoDTO todoDTO);


}
