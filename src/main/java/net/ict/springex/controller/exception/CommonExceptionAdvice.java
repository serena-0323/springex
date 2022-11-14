package net.ict.springex.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@ControllerAdvice //공통어드바이스이며 가장 우선으로 처리된다.
@Log4j2
public class CommonExceptionAdvice {
   /* @ResponseBody //응답받은 바디 안에서
    @ExceptionHandler(NumberFormatException.class)// 해당 내용이 오지 않았을 때
    public String exceptNumber(NumberFormatException numberFormatException) {//지정한 번호가 넘어오지 않으면 예외처리되는 것
        log.error("=======================");
        log.error(numberFormatException.getMessage());
        return "NUMBER FORMAT EXCEPTION"; //리턴값을 처리해줘라 , 예외부분 출력

    }*/

    //예외 처리의 최상의 타입인 Exception 타입을 처리하도록 구성 exceptCommon(Exception exception)
    //범용적으로 예외처리 방식
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exceptCommon(Exception exception) { //디버깅 출력하기
        log.error("===========error===========");
        log.error(exception.getMessage());

        StringBuffer buffer = new StringBuffer("<ul>");
        buffer.append("<li>" + exception.getMessage() + "</li>");
        Arrays.stream(exception.getStackTrace()).forEach(stackTraceElement -> {
            buffer.append("<li>" + stackTraceElement + "</li>");
        });
        buffer.append("</ul>");
        return buffer.toString();

    }
    
    @ExceptionHandler(NoHandlerFoundException.class) //해당되는 페이지가 없을 때
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(){
        return "custom404";
    }
}
