package com.example.springlayerjava.domain.content.entity;

import com.example.springlayerjava.domain.content.dto.ContentRequestDto;
import com.example.springlayerjava.domain.content.dto.ContentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//엔티티입니다.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Content {

    private Long id;
    private String title;
    private String writer;
    private String description;
    private String createdAt;
    private String updatedAt;


    public static List<Content> getMemberContentList(List<Content> contentList, String memberName) {
        List<Content> contents = new ArrayList<>();

        for (Content content : contentList) {
            if(content.getWriter().equals(memberName)){
                contents.add(content);
            }
        }

        return contents;
    }

    public static Content from(ContentRequestDto requestDto) {
        Content content = new Content();
        content.initData(requestDto);
        return content;
    }

    private void initData(ContentRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.description = requestDto.getDescription();
        this.createdAt = requestDto.getCreatedAt();
    }


    public ContentResponseDto to() {
        return new ContentResponseDto(
                this.id,
                this.title,
                this.writer,
                this.description,
                this.createdAt,
                this.updatedAt
        );
    }
}
