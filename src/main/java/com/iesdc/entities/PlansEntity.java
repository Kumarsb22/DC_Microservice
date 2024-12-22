package com.iesdc.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class PlansEntity {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer planId;
	    private String planName;
	    private LocalDateTime planStartDate;
	    private LocalDateTime planEndDate;
	    private String activeSw;
	    @Column(insertable = false)
	    @CreationTimestamp
	    private LocalDateTime createdDate;
	    @Column(insertable = false)
	    @UpdateTimestamp
	    private  LocalDateTime updatedDate;
	    private Integer createdBy;
	    private Integer updatedBy;
	    @OneToOne(mappedBy = "plansEntity")
	    @JoinColumn(name = "plan_id")
	    private PlanSelectionEntity planSelectionEntity;
}
