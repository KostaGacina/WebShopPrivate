package com.webshop.service;
import com.webshop.model.Korisnik;
import com.webshop.model.Proizvod;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;



@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendNewMail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
    }


    /*public void sendAuctionEndNotification(Korisnik buyer, Korisnik seller, Proizvod proizvod) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(buyer.getMejlAdresa());
            helper.setSubject("Auction Ended: " + proizvod.getNaziv());
            helper.setText("Dear " + buyer.getIme() + ",\n\nThe auction for the product '" + proizvod.getNaziv() + "' has ended. You are the winner!\n\nThank you for participating.");

            javaMailSender.send(message);

            // Send email to seller
        } catch (jakarta.mail.MessagingException e) {
            throw new RuntimeException(e);
        }
    }*/
}


