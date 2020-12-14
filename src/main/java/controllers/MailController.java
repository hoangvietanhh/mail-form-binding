package controllers;


import entities.MailBinding;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class MailController {
    @GetMapping("/index")
    public String showForm(ModelMap model) {
        model.addAttribute("mail", new MailBinding());
        return "/form";
    }

    @PostMapping("/save")
    public String submit(@ModelAttribute("mail") MailBinding mailBinding, ModelMap model) {
        model.addAttribute("languages", mailBinding.getLanguages());
        model.addAttribute("pageSize", mailBinding.getPageSize());
        model.addAttribute("spamsFilter", mailBinding.isSpamsFilter());
        model.addAttribute("signature", mailBinding.getSignature());
        return "/infor";
    }
}
