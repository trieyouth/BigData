package com.entity_dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="role"
    ,catalog="bigdata"
)

public class Role  implements java.io.Serializable {


    // Fields    

     private Integer roleId;
     private String roleName;


    // Constructors

    /** default constructor */
    public Role() {
    }

    
    /** full constructor */
    public Role(String roleName) {
        this.roleName = roleName;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="role_id", unique=true, nullable=false)

    public Integer getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    
    @Column(name="role_name", length=100)

    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
   








}