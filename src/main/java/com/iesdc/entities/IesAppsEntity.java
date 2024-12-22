package com.iesdc.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
public class IesAppsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long caseNo;
	private String fullName;
	private String phoneNO;
	private LocalDateTime dob;
	private String gender;
	private String email;
	private String ssn;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	private Integer createdBy;
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Column(insertable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	private Integer updatedBy;

	@OneToOne(mappedBy = "appsEntity")
	@JoinColumn(name = "case_no")
	private IncomeEntity entity;

	@OneToOne(mappedBy = "appsEntity")
	@JoinColumn(name = "case_no")
	private EducationEntity educationEntity;

	@OneToOne(mappedBy = "appsEntity")
	@JoinColumn(name = "case_no")
	private KidsEntity kidsEntity;

	@OneToOne(mappedBy = "appsEntity")
	@JoinColumn(name = "case_no")
	private PlanSelectionEntity planSelectionEntity;
}
