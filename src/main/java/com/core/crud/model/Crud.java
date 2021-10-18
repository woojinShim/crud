package com.core.crud.model;

import com.core.crud.dto.CrudRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본 생성자를 만들어줌
@Getter
@Entity // 테이블과 연계
public class Crud extends TimeStamped{
    // id 자동 생성
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Crud(String username, String contents) {
        this.username = username;
        this.contents = contents;
    }

    public Crud(CrudRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(CrudRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

}
