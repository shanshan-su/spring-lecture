package com.codeup.springlecture;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdController {
    private final AdRespository adDao;

    public AdController(AdRespository adDao) {
        this.adDao = adDao;
    }

    @GetMapping("/ads")
    public String index(Model model) {
        model.addAttribute("ads", adDao.findAll());
        model.addAttribute("topAd", adDao.findAdByTitle("bicycle north side"));
        model.addAttribute("searchAd", adDao.findAdByTitleLike("%childcare%"));
        return "adIndex";
    }



}
