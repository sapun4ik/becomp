package me.becomp.web.controller.personal;

import me.becomp.persistence.model.personal.PAccount;
import me.becomp.service.personal.IPAccountService;
import me.becomp.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by sapun4ik on 17.03.2018.
 */

@Controller
public class PersonalController {

    @Autowired
    IPAccountService pAccountService;

    @RequestMapping(value = "/personal", method = RequestMethod.GET)
    public String getHome(Model model) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.getDefault());
        model.addAttribute("serverTime", dateFormat.format(new Date()));
        model.addAttribute("messages","message");
        return "personal/index.html";
    }
    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public String getHome1(Model model) {
        model.addAttribute("msg","Привет мир!");
        return "content.html";
    }
    @RequestMapping(value = "/account")
    public String addAccount(final Model model) {
        model.addAttribute("account",new PAccount());
        return "/personal/account.html";
    }
    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public String addAccount(final Model model, @ModelAttribute("account") PAccount pAccount) {
        BigDecimal balance = new BigDecimal("999.098");

        pAccount.setBalance(balance);
        pAccountService.addPAccount(pAccount);
        return "personal/index.html";
    }
//    @RequestMapping(value = "/red", method = RequestMethod.GET)
//    public String getHomeRed(Model model,final RedirectAttributes redirectAttributes) {
//        redirectAttributes.addFlashAttribute("message","Added successfully.");
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.getDefault());
//        model.addAttribute("serverTime", dateFormat.format(new Date()));
//        return "redirect:/";
//    }

}