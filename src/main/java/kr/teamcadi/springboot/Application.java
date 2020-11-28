package kr.teamcadi.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
@SpringBootApplication
스프링 부트의 자동 설정, 스프링 Bean읽기와 생성을 모두 자동으로 설정
이 클래스는 항상 프로젝트의 최상단에 위치해야한다.

@EnableJpaAuditing
JPA Auditing 어노테이션들을 모두 활성화할 수 있도록 한다.
 */
@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //SpringApplication.run으로 내장 WAS 실행-항상 톰캣 설치할 필요 없다.
        SpringApplication.run(Application.class, args);
    }
}
