package kr.teamcadi.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*
@RunWith
테스트 진행 시 JUnit에 내장된 실행자 외 다른 실행자를 실행시킨다.
여기서는 SpringRunner라는 스프링 실행자 사용
RunWith으로 스프링 부트 테스트와 JUnit 사이에 연결자 역할 한다.

??SpringRunner
스프링이 가지고 있는 것들 끌어오겠다. (스프링 컨테이너 같은 것들)

@WebMvcTest
여러 스프링 테스트 어노테이션 중 Web에 집중할 수 있는 어노테이션
가짜객체를 만들 클래스를 연결해준다.
여기에서는 HelloController 가짜 객체 만든다.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    /*
    @Autowired
    스프링이 관리하는 빈을 주입받는다.
     */
    @Autowired
    private MockMvc mvc; // 웹 API를 테스트할 때 사용
                         // HTTP GET, POST 등에 대한 API 테스트를 할 수 있다.
                         // 테스트코드에서 쓰일 가짜 객체 (HelloController와 똑같은)

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))          // MockMvc로 /hello 주소로 HTTP GET요청
                .andExpect(status().isOk())             // mvc.perform의 결과 검증 (??200-정상/404/500)
                                                        // postMapping / GetMapping
                .andExpect(content().string(hello));    // "hello" 리턴되는 것이 맞는지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)    //API 테스트할 떄 사용될 요청 파라미터를 설정한다.
                        .param("amount", String.valueOf(amount))) // 값은 String만 허용된다.
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
        /*
        jsonPath
        JSON 응답값을 필드별로 검증할 수 있는 메서드
        $를 기준으로 필드명을 명시한다.
         */
    }
}
