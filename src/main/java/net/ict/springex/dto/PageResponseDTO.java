package net.ict.springex.dto;

/*PageResponseDTO의 기능
* -TodoDTO 목록
* -전체데이터의 수
* -페이지 번호 처리를 위한 데이터(시작페이지 번호/끝페이지 번호)*/

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> { //<E> : 모든 데이터를 PageResponseDTO에 받아서 여기에서 작업할 것이다.
    private int page;             //예로 회원 정보게시판이나 공지사항 도 페이징 처리가 필요하므로 공통처리를 위해 제너릭<E>로 처리
    private int size;
    private int total;

    //시작페이지 번호
    private int start;
    //끝 페이지 번호
    private int end;

    //이전 페이지의 존재 여부
    private boolean prev;
    //다음페이지의 존재 여부
    private boolean next;

    private List<E> dtoList;


    @Builder(builderMethodName = "withAll")//제너릭을 이용해서 작업을 하는데 생성자를 만든 후 생성자를 받아 온다.
    public PageResponseDTO(PageRequestDTO pageReuestDTO, List<E> dtoList, int total){ //생성자
        this.page = pageReuestDTO.getPage(); //이미 set,get이 만들어져 있어서 불러와 사용할 수 있다.
        this.size = pageReuestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;
        this.end = (int)(Math.ceil(this.page / 10.0 )) * 10; //1.마지막 페이지(end)를 수하는 계산식 end는 현재페이지 번호를 기준으로 계산
        this.start = this.end - 9;                           //2.시작페이지의 경우 계산한 마지막 페이지에서 -9
        int last = (int)(Math.ceil((total/(double)size)));  //3.시작페이지를 구성한 후 마지막 페이지는 다시 전체갯수를 고료하여 만약10개씩(size)
                                                            //3-1.를 보여주는 경우, 전체개수를 구하여 last를 구해야 한다.
                                                            //3-2.만약 전체 개수가 75개라면 마지막페이지는 75/10.0 =>7.5=>8
        this.end = end > last ? last: end;                 //4.마지막페이지는 앞에서 구현한 last값보다 작은경우는 last 가 end가 된다ㅓ.
        this.prev = this.start > 1;                        //5.이전 페이지(prev)존재 여부는 시작 페이지가 1이 아니라면 무조건 true
        this.next = total > this.end * this.size;          //6.다음페이지(next)는 마지막 페이지(end)와 페이지 수 (size)를 곱한 값보다.전체개수(total)이 더 많은지 체크하여 판단한다.

    }

}
