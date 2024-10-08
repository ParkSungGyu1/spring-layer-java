package com.example.springlayerjava.domain.content.repository;


import com.example.springlayerjava.domain.content.entity.Content;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContentRepository {
    public Content findById(Long id) {
        return new Content(
                id,
                "title1",
                "writer1",
                "desc1",
                "2024-10-10",
                "2024-10-11"
        );
    }

    public List<Content> findAll() {
        ArrayList<Content> contents = new ArrayList<>();;
        contents.add(new Content(1L,"writer1", "title1", "desc1", "2024-10-10", "2024-10-11"));
        contents.add(new Content(2L,"writer2", "title2", "desc2", "2024-10-11", "2024-10-11"));
        contents.add(new Content(3L,"writer3", "title3", "desc3", "2024-10-12", "2024-10-12"));
        contents.add(new Content(4L,"writer4", "title4", "desc4", "2024-10-13", "2024-10-12"));
        return contents;
    }

    public void save(Content content) {

        /**
         * 저장하는 로직 수행~
         */
    }
}
