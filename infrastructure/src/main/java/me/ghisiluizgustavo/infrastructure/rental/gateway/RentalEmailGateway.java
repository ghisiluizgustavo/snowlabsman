package me.ghisiluizgustavo.infrastructure.rental.gateway;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ghisiluizgustavo.domain.customer.model.Customer;
import me.ghisiluizgustavo.domain.rental.gateway.RentalEmailNotificationGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class RentalEmailGateway implements RentalEmailNotificationGateway {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;


    @Override
    public void sendEmail( Customer customer, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(customer.email());
        mailMessage.setSubject("Book rented");
        mailMessage.setFrom(from);
        mailMessage.setText(message);

        javaMailSender.send(mailMessage);
        log.info("Email sent to " + customer.email());
    }
}
