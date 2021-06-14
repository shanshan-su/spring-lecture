package com.codeup.springlecture.daos;

import com.codeup.springlecture.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdRespository extends JpaRepository<Ad, Long> {
    Ad findAdByTitle(String title);

    Ad findAdByTitleLike(String searchPattern); // find by title "%input%"

    List<Ad> searchByTitle(String term);
}
