package com.cibt.app.mailsender.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    
    @Autowired
    private MailSender sender;

    @GetMapping
    public String index(){
        return "home/index";
    }


    @GetMapping(value = "/mail")
    @ResponseBody
    public String mail(@RequestParam("mail")String mail,
    @RequestParam("subject")String subject,
    @RequestParam("sendto")String sendto){
        SimpleMailMessage message=new SimpleMailMessage();
       
        message.setTo(sendto);
        message.setSubject(subject);
        message.setText(mail);
      sender.send(message);

       return "success";
    }
}