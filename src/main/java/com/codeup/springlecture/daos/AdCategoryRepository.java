package com.codeup.springlecture.daos;

import com.codeup.springlecture.models.AdCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdCategoryRepository extends JpaRepository<AdCategory, Long> {

}
