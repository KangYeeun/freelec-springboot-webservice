package com.jojoldu.book2.springboot.web.dto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);       //롬복의 @Require~로 생성자가 자동으로 생성

        //then
        assertThat(dto.getName()).isEqualTo(name);          //롬복의 @Getter로 get메소드 자동 생성 확인
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
