package kr.teamcadi.springboot.web;


import kr.teamcadi.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
@RestController
JSON을 반환하는 컨트롤러로 만들어준다
(전에는 각 메서드마다 @ResponseBody를 선언했었다)
 */
@RestController
public class HelloController {
    /*
    @GetMapping
    HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어준다.
     */
    @GetMapping("/hello")
    public String hello() {
        // /hello로 요청이 오면 문자열 hello를 반환하는 기능
        return "hello";
    }

    /*
    @RequestParam
    외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
    외부에서 name이란 이름으로 넘긴 파라미터를 메서드 파라미터 name에 저장한다.
     */
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }


}
