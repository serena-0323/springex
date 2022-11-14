package net.ict.springex.mapper;

import net.ict.springex.domain.TodoVO;

public interface TodoMapper { //resources 에 같은 이름으로 xml 만들어야 함
    String getTime();

    void insert(TodoVO todoVO); //파라미터 받기
}
