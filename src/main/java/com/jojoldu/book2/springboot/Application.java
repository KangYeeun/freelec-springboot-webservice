package com.jojoldu.book2.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// @EnableJpaAuditing
@SpringBootApplication          // 스프링 부트의 자동 설정, 스프링 Bean읽기와 생성을 자동으로 설정
public class Application {      // 프로젝트의 메인 클래스
    public static void main(String[] args) {SpringApplication.run(Application.class,args);}
    //메인 메소드에서 실행하는 SpringApplication.run으로 인해 내장 WAS를 실행
    //별도로 외부네 웹 애플리케이션 서버를 두지 않고 애플리케이션을 실행할 때 내부에서 WAS를 실행함 => 서버에 톰캣 설치가 필요 없음
    //스프링 부트로 만들어진 Jar 파일로 실행하면 됨
    //내장WAS는 언제 어디서나 같은 환경에서 스프링 부트를 배포 가능
}
//@이후부터 설정을 읽어가기에 이 클래스는 항상 프로젝트의 최상단에 위치해야함
