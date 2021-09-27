package sds.qst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sds.qst.repo.CurrencyRepo;

@Controller
@RequestMapping("")
public class WebController {
    private final CurrencyRepo currencyRepo;

    public WebController(CurrencyRepo currencyRepo) {
        this.currencyRepo = currencyRepo;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("currencies", currencyRepo.findAll());

        return "index";
    }
}
