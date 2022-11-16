package net.ict.springex.dto;


//페이지 처리는 현재 페이지 번호(page), 한 페이지당 데이터 수 (size)를 의미한다.

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO { //서버에서 보내주는 데이터 페이지
    @Builder.Default //page,size의 기본값
    @Min(value = 1)
    @Positive //양수
    private int page = 1;

    @Builder.Default //상수, 고정값
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;


    public int getSkip(){ // 전 페이지로 이동
        return (page-1)*10;
    }
}
