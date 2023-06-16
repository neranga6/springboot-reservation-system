package com.webapp.neo.webapp.neo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ContactController {

    private final EmailService emailService;

    @Autowired
    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @PostMapping("/contact")
    public RedirectView submitContactForm(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("message") String message) {

        String to = "neranga65@gmail.com"; // Replace with the recipient's email address
        String subject = "New Contact Message";
        String content = "Name: " + name + "\n"
                + "Email: " + email + "\n"
                + "Message: " + message;
        emailService.sendEmail(to, subject, content);

        return new RedirectView("/success");
    }

    @GetMapping("/success")
    public ModelAndView successView(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }
}