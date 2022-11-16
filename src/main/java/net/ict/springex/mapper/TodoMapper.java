package net.ict.springex.mapper;

import net.ict.springex.domain.TodoVO;
import net.ict.springex.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper { //resources 에 같은 이름으로 xml 만들어야 함
    String getTime();

    void insert(TodoVO todoVO); //파라미터 받기

    List<TodoVO> selectAll();

    TodoVO selectOne(Long tno);

    void delete(Long tno);

    void update(TodoVO todoVO);

    List<TodoVO>selectList(PageRequestDTO pageReuestDTO);
    int getCount(PageRequestDTO pageReuestDTO);


}
