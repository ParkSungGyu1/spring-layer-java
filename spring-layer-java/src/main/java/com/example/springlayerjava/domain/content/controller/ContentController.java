package com.example.springlayerjava.domain.content.controller;

import com.example.springlayerjava.domain.content.dto.ContentRequestDto;
import com.example.springlayerjava.domain.content.dto.ContentResponseDto;
import com.example.springlayerjava.domain.content.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @GetMapping()
    public List<ContentResponseDto> getContents(){
        return contentService.getContent1();
    }

    @PostMapping
    public void createContent(){
        //@RequestBody 대신!
        ContentRequestDto contentRequestDto = new ContentRequestDto("title1", "writer1", "description", "2024-10-09", "2024-10-10");
        contentService.createContent1(contentRequestDto);
    }
}
