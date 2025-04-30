package com.in.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String recipientEmail;
    private String subject;
    @Column
    private String body;
    private Status status;
    private LocalDate scheduledDate;
    
    public static enum Status {
        PENDING,
        SENT;
    	private Status() {
			
		}
    }
}
