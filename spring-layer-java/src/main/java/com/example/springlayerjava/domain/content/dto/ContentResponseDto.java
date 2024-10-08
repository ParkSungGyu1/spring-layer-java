package com.example.springlayerjava.domain.content.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ContentResponseDto {
    private Long id;
    private String title;
    private String writer;
    private String description;
    private String createdAt;
    private String updatedAt;
}
