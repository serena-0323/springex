package net.ict.springex.dto;

import lombok.*;

import java.time.LocalDate;

//객체 자료형은 파라미터로 초리하기 위해서는 객체로 생성되고 setXXX()이 메서드를 이용해서 처리해야 한다.
@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
    private String writer; //작성자를 의미  ==> 이것들을 처리하는 컨트롤러 만들기(todo)
    

}
