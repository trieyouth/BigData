package com.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Roleauthority entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="roleauthority"
    ,catalog="bigdata"
)

public class Roleauthority  implements java.io.Serializable {


    // Fields    

     private RoleauthorityId id;


    // Constructors

    /** default constructor */
    public Roleauthority() {
    }

    
    /** full constructor */
    public Roleauthority(RoleauthorityId id) {
        this.id = id;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="authId", column=@Column(name="auth_id", nullable=false) ), 
        @AttributeOverride(name="roleId", column=@Column(name="role_id", nullable=false) ) } )

    public RoleauthorityId getId() {
        return this.id;
    }
    
    public void setId(RoleauthorityId id) {
        this.id = id;
    }
   








}