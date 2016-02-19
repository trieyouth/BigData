package com.entity_dao;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Adimauthority entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="adimauthority"
    ,catalog="bigdata"
)

public class Adimauthority  implements java.io.Serializable {


    // Fields    

     private AdimauthorityId id;


    // Constructors

    /** default constructor */
    public Adimauthority() {
    }

    
    /** full constructor */
    public Adimauthority(AdimauthorityId id) {
        this.id = id;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="authId", column=@Column(name="auth_id", nullable=false) ), 
        @AttributeOverride(name="adminId", column=@Column(name="admin_id", nullable=false) ) } )

    public AdimauthorityId getId() {
        return this.id;
    }
    
    public void setId(AdimauthorityId id) {
        this.id = id;
    }
   








}