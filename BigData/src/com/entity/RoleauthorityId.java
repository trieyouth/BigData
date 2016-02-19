package com.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * RoleauthorityId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class RoleauthorityId  implements java.io.Serializable {


    // Fields    

     private Integer authId;
     private Integer roleId;


    // Constructors

    /** default constructor */
    public RoleauthorityId() {
    }

    
    /** full constructor */
    public RoleauthorityId(Integer authId, Integer roleId) {
        this.authId = authId;
        this.roleId = roleId;
    }

   
    // Property accessors

    @Column(name="auth_id", nullable=false)

    public Integer getAuthId() {
        return this.authId;
    }
    
    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    @Column(name="role_id", nullable=false)

    public Integer getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RoleauthorityId) ) return false;
		 RoleauthorityId castOther = ( RoleauthorityId ) other; 
         
		 return ( (this.getAuthId()==castOther.getAuthId()) || ( this.getAuthId()!=null && castOther.getAuthId()!=null && this.getAuthId().equals(castOther.getAuthId()) ) )
 && ( (this.getRoleId()==castOther.getRoleId()) || ( this.getRoleId()!=null && castOther.getRoleId()!=null && this.getRoleId().equals(castOther.getRoleId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAuthId() == null ? 0 : this.getAuthId().hashCode() );
         result = 37 * result + ( getRoleId() == null ? 0 : this.getRoleId().hashCode() );
         return result;
   }   





}