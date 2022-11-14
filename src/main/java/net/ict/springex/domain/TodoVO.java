package net.ict.springex.domain;

/*MyBatis와 스프링을 이용해 영속적인 처리를 위한 단계
* 1. VO선언
* 2. MApper 인터페이스 개발
* 3. XML 개발
* 4. 테스트 코드 개발*/

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
    private String writer; //작성자를 의미  ==> 이것들을 처리하는 컨트롤러 만들기(todo)

}
