package com.example.kurmap.Dog;

import com.example.kurmap.Dog.model.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DogController {
    @Autowired
    private DogService dogService;

    @GetMapping("/mapmain.do")
    public String mapmain(Model model, String hospitalname, String fin) {
        model.addAttribute("list",dogService.selectList());
        model.addAttribute("searchlist", dogService.selectSearchList(hospitalname));
        model.addAttribute("fin", fin);
        return "Map/mapmain";
    }



}