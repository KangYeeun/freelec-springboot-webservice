package com.jojoldu.book2.springboot.domain.posts;

import com.jojoldu.book2.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity     //테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {

    @Id         // 해당 테이블의 PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //PK의 생성규칙
    private Long id;

    @Column(length = 500,nullable =  false)         //테이블의 칼럼. 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨, 수정이 필요한 경우 명시
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;          //칼럼에 자동 추가

    @Builder                    // 클래스의 빌더 패턴 클래스 생성. 생성자 위에 선언하면 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
