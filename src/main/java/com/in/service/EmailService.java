package com.in.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.in.entity.Email;
import com.in.repository.EmailRepository;

@Service
public class EmailService {
	@Autowired
	private EmailRepository repository;

	@Autowired
	private JavaMailSender mailSender;

	public void sendMail(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		mailSender.send(message);
	}

	public Email scheduleEmail(Email email) {
		return repository.save(email);
	}

	public List<Email> getAll() {
		return repository.findAll();
	}

	@Scheduled(cron = "0 30 8 * * ?")
	public void sendScheduledEmails() {
		List<Email> emails = repository.findByScheduledDateAndStatus(LocalDate.now(), Email.Status.PENDING);
		for (Email email : emails) {
			sendMail(email.getRecipientEmail(), email.getSubject(), email.getBody());
			email.setStatus(Email.Status.SENT);
		}
		repository.saveAll(emails);
	}

}
