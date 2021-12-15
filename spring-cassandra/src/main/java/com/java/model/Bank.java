package com.java.model;

import lombok.*;

import java.time.LocalDateTime;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
	
	public Bank(String bank_reg_number, String bank_identification_code, String bank_name, String country,
			String registered_address, LocalDateTime maker_date, LocalDateTime checker_date, String maker_id,
			String checker_id, String modified_by, LocalDateTime modified_date) {
		super();
		this.bank_reg_number = bank_reg_number;
		this.bank_identification_code = bank_identification_code;
		this.bank_name = bank_name;
		this.country = country;
		this.registered_address = registered_address;
		this.maker_date = maker_date;
		this.checker_date = checker_date;
		this.maker_id = maker_id;
		this.checker_id = checker_id;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}
	
    @PrimaryKey
	private long bank_id;
	
	private String bank_reg_number;

	private String bank_identification_code;

	private String bank_name;

	private String country;

	private String registered_address;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime maker_date;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime checker_date;
	
	private String maker_id;
	
	private String checker_id;
	
	private String modified_by;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime modified_date;
}
