package com.qltccn.nhom2.controller;

import com.qltccn.nhom2.model.Income;
import com.qltccn.nhom2.model.Pay;
import com.qltccn.nhom2.model.User;
import com.qltccn.nhom2.server.IncomeService;
import com.qltccn.nhom2.server.PayService;
import com.qltccn.nhom2.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class JumpController {

    @Autowired
    private IncomeService incomeService;
    @Autowired
    private PayService payService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        User user = (User) WebUtils.getSession().getAttribute("user");
        model.addAttribute("user", user);

        BigDecimal income = incomeService.selectTotalIncome(user.getId());
        BigDecimal pay = payService.selectTotalIncome(user.getId());
        BigDecimal total = income.subtract(pay);

        BigDecimal warn = user.getWarn();
        if (total.compareTo(warn) < 0) {
            model.addAttribute("warn", "Đã vượt quá hạn mức chi tiêu!");
        } else {
            model.addAttribute("warn", "Tình trạng chi tiêu hiện tại không có khoản nào vượt quá hạn mức");
        }

        System.out.println(total);
        return "index";
    }


    @RequestMapping("/toAddincome")
    public String toAddincome(Model model) {
        User user = (User) WebUtils.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "addincome";
    }

    @RequestMapping("/toUpdateincome")
    public String toUpdateincome(@RequestParam("id") int id, Model model) {
        User user = (User) WebUtils.getSession().getAttribute("user");
        model.addAttribute("user", user);
        Income income = incomeService.getById(id);
        model.addAttribute("income", income);
        return "addincome";
    }

    @RequestMapping("/toAddspending")
    public String toAddspending(Model model) {
        User user = (User) WebUtils.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "addspending";
    }

    @RequestMapping("/toUpdatespending")
    public String toUpdatepay(@RequestParam("id") int id, Model model) {
        User user = (User) WebUtils.getSession().getAttribute("user");
        model.addAttribute("user", user);
        Pay pay = payService.getById(id);
        model.addAttribute("pay", pay);
        return "addspending";
    }

    @RequestMapping("/toSetting")
    public String toSetting(Model model) {
        User user = (User) WebUtils.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "setting";
    }

    @RequestMapping("/toAbout")
    public String toAbout(Model model) {
        User user = (User) WebUtils.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "about";
    }

    @RequestMapping("/toGenerate")
    public String toGenerate(Model model) {
        User user = (User) WebUtils.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "generate";
    }

    @RequestMapping("/tosetPassword")
    public String tosetPassword(Model model) {
        User user = (User) WebUtils.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "changepswd";
    }

    @RequestMapping("/tosetWarnd")
    public String tosetWarnd(Model model) {
        User user = (User) WebUtils.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "changelimit";
    }
}
