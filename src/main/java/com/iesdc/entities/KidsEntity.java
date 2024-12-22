package com.iesdc.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class KidsEntity {

	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer kidId;
		private String kidName;
		private LocalDateTime kidDob;
		@OneToOne
		private IesAppsEntity appsEntity;
}
