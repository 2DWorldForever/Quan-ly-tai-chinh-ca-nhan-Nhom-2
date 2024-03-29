package com.qltccn.nhom2.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qltccn.nhom2.model.Income;
import com.qltccn.nhom2.model.Pay;
import com.qltccn.nhom2.model.User;
import com.qltccn.nhom2.util.WebUtils;
import com.qltccn.nhom2.server.IncomeService;
import com.qltccn.nhom2.server.PayService;
import com.qltccn.nhom2.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private IncomeService incomeService;
    @Autowired
    private PayService payService;

    @RequestMapping("/register")
    public String register(@RequestParam("uname") String uname,
                          @RequestParam("password") String password,
                           @RequestParam("warn") BigDecimal warn,
                           Model model) {
        User user = new User();
        user.setUname(uname);
        user.setPassword(password);
        user.setWarn(warn);
        boolean res = userService.save(user);

        Income income = new Income();
        income.setMoney(BigDecimal.valueOf(0));
        income.setUserId(user.getId());
        incomeService.save(income);

        Pay pay = new Pay();
        pay.setMoney(BigDecimal.valueOf(0));
        pay.setUserId(user.getId());
        payService.save(pay);

        if (res) {
            // System.out.println(user);
            return "login";
        }

        model.addAttribute("error", "Xảy ra lỗi, xin vui lòng thử lại");
        return "register";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "uname") String uname,
                        @RequestParam(value = "password") String password,
                        Model model, HttpSession session) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uname", uname);
        queryWrapper.eq("password", password);
        User user = userService.getOne(queryWrapper);
        if (null == user) {
            model.addAttribute("error", "Sai tên người dùng hoặc mật khẩu");
            return "login";
        }
        // System.out.println(user);
        session.setAttribute("user", user);
        model.addAttribute("user", user);
//        System.out.println(user);
        return "redirect:/index";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }

    @RequestMapping("/userInfo")
    public String userInfo(Model model) {
        User user = (User) WebUtils.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "setting";
    }

    @RequestMapping("/resetPassword")
    public String resetPassword(@RequestParam("password") String password,
                                Model model) {
        User user = (User) WebUtils.getSession().getAttribute("user");
        model.addAttribute("user", user);
        user.setPassword(password);
        userService.updateById(user);
        return "redirect:/userInfo";
    }

    @RequestMapping("/resetWarn")
    public String resetWarn(@RequestParam("warn") BigDecimal warn,
                                Model model) {
        User user = (User) WebUtils.getSession().getAttribute("user");
        model.addAttribute("user", user);
        user.setWarn(warn);
        userService.updateById(user);
        return "redirect:/userInfo";
    }

    @GetMapping("/")
    public String index() {
        return "login";
    }
}
