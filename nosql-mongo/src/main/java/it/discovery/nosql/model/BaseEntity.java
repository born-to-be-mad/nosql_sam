package it.discovery.nosql.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
@ToString
public abstract class BaseEntity {
	@Id
	private String id;

	@CreatedDate
	private LocalDateTime created;

	@LastModifiedDate
	private LocalDateTime modified;
}
