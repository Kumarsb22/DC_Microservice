package com.iesdc.entities;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String fullName;
	private String email;
	private String pazzword;
	private String phonNo;
	private char gender;
	private LocalDateTime dob;
	private String ssn;
	private String activeSw;
	private String activeStatus;
	private String roleName;
	@OneToMany(mappedBy = "user")
	private List<IesAppsEntity> iesAppsEntity;
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	@Column(insertable = false)
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	private Integer createdBy;
	private Integer updatedBy;
}
