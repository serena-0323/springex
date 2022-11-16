package net.ict.springex.mapper;


import lombok.extern.log4j.Log4j2;
import net.ict.springex.domain.TodoVO;
import net.ict.springex.dto.PageRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTest {
    @Autowired(required = false)
    private TodoMapper todoMapper;
    @Test
    public void testGetTime(){
        log.info(todoMapper.getTime());
    }

    @Test
    public void testInsert(){
        TodoVO todoVO = TodoVO.builder()
                .title("spring Test")
                .dueDate(LocalDate.of(2022,11,14))
                .writer("ict05")
                .build();
        todoMapper.insert(todoVO); //todoMapper에 넘긴다
    }

   /* @Test
    public void testSelectAll(){ // 작성 후 동작이 잘 되면 페이지에 뿌려주러 가기~
        List<TodoVO> voList = todoMapper.selectAll();
        voList.forEach(vo -> log.info(vo)); //한 row 씩 가져온다.
    }*/

    @Test
    public void testDelete(){
        TodoVO todoVO = TodoVO.builder()
                .tno((1L))
                .build();
        todoMapper.delete(todoVO.getTno());




    }
    @Test
    public void testSelectList(){
        PageRequestDTO pageReuestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();
        List<TodoVO> voList = todoMapper.selectList(pageReuestDTO);
        voList.forEach(vo ->log.info(vo));
    }


}


