package com.rest.controller.restapi.entity;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// @Data annotation includes Getter , Setter, RequiredArgsConstructor 
// ToString EqualsAndHashCode method...

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter(AccessLevel.PUBLIC)
//@Setter(AccessLevel.PUBLIC)
//@ToString

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="course_details")
public class Course extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long courseID;
	
	@Column(name = "c_name", length = 20)
	private String courseName;
	
	@Column(name= "c_desc", length= 40)
	private String courseDesc;
	
	@Transient
	private String hidden;
	
	 @PrePersist
	    protected void prePersist() {
		 System.out.println("Inside prePersist() method!!");
//		 DateTimeFormatter.ofPattern("YYYY-MM-DD", Locale.US);
	        if (this.getCreatedAt() == null)  this.setCreatedAt(LocalDateTime.now());
	        if (this.getUpdatedAt() == null) this.setUpdatedAt(LocalDateTime.now());
	    }

	    @PreUpdate
	    protected void preUpdate() {
	    	System.out.println("Inside preUpdate() method!!");
	        this.setUpdatedAt(LocalDateTime.now());
	    }

	    @PreRemove
	    protected void preRemove() {
	    	System.out.println("Inside preRemove() method!!");
	        this.setUpdatedAt(LocalDateTime.now());
	    }
}
