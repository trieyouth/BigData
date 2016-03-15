package com.zero.entity;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Secondtemplateuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "secondtemplateuser", catalog = "finabigdata")
public class Secondtemplateuser implements java.io.Serializable {

	// Fields

	private Integer tempId;
	private Integer adminId;
	private Date useDate;
	private Time useTime;
	private Long dataNumber;

	// Constructors

	/** default constructor */
	public Secondtemplateuser() {
	}

	/** full constructor */
	public Secondtemplateuser(Integer adminId, Date useDate, Time useTime,
			Long dataNumber) {
		this.adminId = adminId;
		this.useDate = useDate;
		this.useTime = useTime;
		this.dataNumber = dataNumber;
	}

	// Property accessors
	@Id
	//@GeneratedValue
	@Column(name = "temp_id", unique = true, nullable = false)
	public Integer getTempId() {
		return this.tempId;
	}

	public void setTempId(Integer tempId) {
		this.tempId = tempId;
	}

	@Column(name = "admin_id")
	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "use_date", length = 10)
	public Date getUseDate() {
		return this.useDate;
	}

	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}

	@Column(name = "use_time", length = 8)
	public Time getUseTime() {
		return this.useTime;
	}

	public void setUseTime(Time useTime) {
		this.useTime = useTime;
	}

	@Column(name = "data_number")
	public Long getDataNumber() {
		return this.dataNumber;
	}

	public void setDataNumber(Long dataNumber) {
		this.dataNumber = dataNumber;
	}

}