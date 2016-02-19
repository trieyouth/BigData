package com.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Adminrole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="adminrole")

public class Adminrole  implements java.io.Serializable {


    // Fields    

     private AdminroleId id;


    // Constructors

    /** default constructor */
    public Adminrole() {
    }

    
    /** full constructor */
    public Adminrole(AdminroleId id) {
        this.id = id;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="roleId", column=@Column(name="role_id", nullable=false) ), 
        @AttributeOverride(name="adminId", column=@Column(name="admin_id", nullable=false) ) } )

    public AdminroleId getId() {
        return this.id;
    }
    
    public void setId(AdminroleId id) {
        this.id = id;
    }
   








}