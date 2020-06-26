package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
public abstract class BaseEntity {
	@Id
	private Integer id;

	@CreatedDate
	private LocalDateTime created;

	@LastModifiedDate
	private LocalDateTime modified;

	public void OnPersist() {
		created = LocalDateTime.now();
	}

	public void onUpdate() {
		modified = LocalDateTime.now();
	}
}
