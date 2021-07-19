package com.codeup.springlecture.daos;

import com.codeup.springlecture.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdsRepository extends JpaRepository<Ad, Long> {
    @Query("from Ad as a where a.title like %:term% or a.description like %:term%")
    List<Ad> searchByTitle(String term);

    Ad findByTitle(String ad_to_be_deleted);
}
