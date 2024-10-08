package com.example.springlayerjava.domain.content.service;

import com.example.springlayerjava.domain.content.dto.ContentRequestDto;
import com.example.springlayerjava.domain.content.dto.ContentResponseDto;
import com.example.springlayerjava.domain.content.entity.Content;
import com.example.springlayerjava.domain.content.repository.ContentRepository;
import com.example.springlayerjava.domain.member.entity.Member;
import com.example.springlayerjava.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;
    private final MemberRepository memberRepository;


    /**
     * TODO(___BAD CASE___)
     *
     * @return
     */
    public List<ContentResponseDto> getContent1() {
        List<Content> contents = contentRepository.findAll();
        Member member = memberRepository.findById(1L);

        List<Content> newContents = new ArrayList<>();

        /**
         * 특정 멤버가 작성한 게시글만 조회하는 로직
         */
        for (Content content : contents) {
            if (content.getWriter().equals(member.getMemberName())){
                newContents.add(content);
            }
        }

        /**
         * 특정 날짜의 게시글인지
        for (Content newContent : newContents) {
            if (newContent.getCreatedAt().equals("2024-10-18")){
                //and so on..
            }
        }*/

        // DAO -> DTO
        List<ContentResponseDto> responseDtoList = new ArrayList<>();
        for (Content newContent : newContents) {
            responseDtoList.add(new ContentResponseDto(
                    newContent.getId(),
                    newContent.getTitle(),
                    newContent.getWriter(),
                    newContent.getDescription(),
                    newContent.getCreatedAt(),
                    newContent.getUpdatedAt()
            ));
        }

        return responseDtoList;

    }

    public List<ContentResponseDto> getContent2(){
        List<Content> contents = contentRepository.findAll();
        Member member = memberRepository.findById(1L);

        /**
         * 특정 멤버가 작성한 게시글만 조회하는 로직
         */
        List<Content> newContents = Content.getMemberContentList(contents, member.getMemberName());

        // DAO -> DTO
        return newContents.stream()
                .map(Content::to)
                .toList();
    }

    public void createContent1(ContentRequestDto requestDto) {
        // DTO -> DAO
        Content content = new Content();
        content.setTitle(requestDto.getTitle());
        content.setWriter(requestDto.getWriter());
        content.setDescription(requestDto.getDescription());
        content.setCreatedAt(requestDto.getCreatedAt());
        contentRepository.save(content);
    }

    public void createContent2(ContentRequestDto requestDto) {
        // DTO -> DAO
        Content content = Content.from(requestDto);

        contentRepository.save(content);
    }

    /**
     *
     * TODO(생각해보면 좋을 내용)
     * TODO(1. 내가 만든 로직에서 서비스에 집중되어 있는 로직은 없을까? (update 할때 특히 주목))
     * TODO(2. 객체의 책임과 역할에 대한 분리를 확실하게 진행하고 있는 것일까?)
     * TODO(3. 다양하게 적용되어 있는 예외처리들은 어디에 책임을 두고 개발하는 것이 좋을까?)
     *
     */
}
