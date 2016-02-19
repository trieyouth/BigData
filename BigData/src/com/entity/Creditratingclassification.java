package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Creditratingclassification entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="creditratingclassification"
    ,catalog="bigdata"
)

public class Creditratingclassification  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String score;
     private String grade;
     private String creditRecord;
     private String creditAbility;
     private String degreeOfRisk;
     private String numberOfUsers;


    // Constructors

    /** default constructor */
    public Creditratingclassification() {
    }

    
    /** full constructor */
    public Creditratingclassification(String score, String grade, String creditRecord, String creditAbility, String degreeOfRisk, String numberOfUsers) {
        this.score = score;
        this.grade = grade;
        this.creditRecord = creditRecord;
        this.creditAbility = creditAbility;
        this.degreeOfRisk = degreeOfRisk;
        this.numberOfUsers = numberOfUsers;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="ID", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="score", length=50)

    public String getScore() {
        return this.score;
    }
    
    public void setScore(String score) {
        this.score = score;
    }
    
    @Column(name="grade", length=50)

    public String getGrade() {
        return this.grade;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    @Column(name="creditRecord", length=50)

    public String getCreditRecord() {
        return this.creditRecord;
    }
    
    public void setCreditRecord(String creditRecord) {
        this.creditRecord = creditRecord;
    }
    
    @Column(name="creditAbility", length=50)

    public String getCreditAbility() {
        return this.creditAbility;
    }
    
    public void setCreditAbility(String creditAbility) {
        this.creditAbility = creditAbility;
    }
    
    @Column(name="degreeOfRisk", length=50)

    public String getDegreeOfRisk() {
        return this.degreeOfRisk;
    }
    
    public void setDegreeOfRisk(String degreeOfRisk) {
        this.degreeOfRisk = degreeOfRisk;
    }
    
    @Column(name="numberOfUsers", length=50)

    public String getNumberOfUsers() {
        return this.numberOfUsers;
    }
    
    public void setNumberOfUsers(String numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }
   








}