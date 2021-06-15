package com.codeup.springlecture.controllers;

import com.codeup.springlecture.models.Ad;
import com.codeup.springlecture.daos.AdRespository;
import com.codeup.springlecture.models.User;
import com.codeup.springlecture.daos.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdController {
    private final AdRespository adsDao;
    private final UsersRepository usersDao;

    public AdController(AdRespository adRespository, UsersRepository usersRepository) {
        this.adsDao = adRespository;
        this.usersDao = usersRepository;
    }

    @GetMapping("/ads")
    public String index(Model model) {
        List<Ad> adsList = adsDao.findAll();
        model.addAttribute("noAdsFound", adsList.size() == 0);
        model.addAttribute("ads", adsList);
        return "ads/index";
    }

    @GetMapping("/ads/{id}")
    public String show(@PathVariable long id, Model model){
        model.addAttribute("adId", id);
        model.addAttribute("ad", adsDao.getById(id));
        return "ads/show";
    }

    @GetMapping("/ads/create")
    public String showForm(Model model) {
        model.addAttribute("ad", new Ad());
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String save(@ModelAttribute Ad ad) {
        User user = usersDao.getById(1L);
        ad.setOwner(user);
        Ad savedAd = adsDao.save(ad);
        return "redirect:/ads/" + savedAd.getId();
    }

    @GetMapping("/ads/{id}/edit")
    public String showEditFrom(Model model, @PathVariable long id) {
        // find an ad
        Ad adToEdit = adsDao.getById(id);
        model.addAttribute("ad", adToEdit);
        return "ads/edit";
    }

    @PostMapping("/ads/{id}/edit")
    @ResponseBody
    public String update(@PathVariable long id,
                         @RequestParam(name = "title") String title,
                         @RequestParam(name = "description") String desc){
        // find an ad
        Ad foundAd = adsDao.getById(id); // select * from ads where id = ?
        // edit the ad
        foundAd.setTitle(title);
        foundAd.setDescription(desc);
        // save the changes
        adsDao.save(foundAd); // update ads set title = ? where id = ?
        return "ad updated";
    }

    @PostMapping("/ads/{id}/delete")
    public String destroy(@PathVariable long id){
        adsDao.deleteById(id);
        return "redirect:/ads";
    }

    @GetMapping("/search")
    public String searchResults(Model model, @RequestParam(name = "term") String term){
        List<Ad> ads = adsDao.searchByTitle(term);
        model.addAttribute("ads", ads);
        return "ads/index";
    }
}
