package com.in.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.entity.Email;

public interface EmailRepository extends JpaRepository<Email, Integer>{
	List<Email> findByScheduledDateAndStatus(LocalDate date, Email.Status status);

}
