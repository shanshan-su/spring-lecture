package com.codeup.springlecture;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRespository extends JpaRepository<Ad, Long> {
    Ad findAdByTitle(String title);

    Ad findAdByTitleLike(String searchPattern); // find by title "%input%"
}
