package kr.teamcadi.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        /*
        assertThat
        테스트 검증 라이브러리의 검증 메서드
        검증하고 싶은 대상을 메서드 인자로 받는다.
        메서드 체이닝이 지원되어 메서드를 이어서 사용할 수 있다.

        isEqualTo
        assertThat에 있는 값과 isEqualTo의 값을 비교하여 값을 때만 성공이다.
         */
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}

/*
테스트코드 에러 발생
해결 : https://tube-life.tistory.com/14
 */
