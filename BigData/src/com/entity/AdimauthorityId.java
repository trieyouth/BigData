package com.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * AdimauthorityId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AdimauthorityId  implements java.io.Serializable {


    // Fields    

     private Integer authId;
     private Integer adminId;


    // Constructors

    /** default constructor */
    public AdimauthorityId() {
    }

    
    /** full constructor */
    public AdimauthorityId(Integer authId, Integer adminId) {
        this.authId = authId;
        this.adminId = adminId;
    }

   
    // Property accessors

    @Column(name="auth_id", nullable=false)

    public Integer getAuthId() {
        return this.authId;
    }
    
    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    @Column(name="admin_id", nullable=false)

    public Integer getAdminId() {
        return this.adminId;
    }
    
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AdimauthorityId) ) return false;
		 AdimauthorityId castOther = ( AdimauthorityId ) other; 
         
		 return ( (this.getAuthId()==castOther.getAuthId()) || ( this.getAuthId()!=null && castOther.getAuthId()!=null && this.getAuthId().equals(castOther.getAuthId()) ) )
 && ( (this.getAdminId()==castOther.getAdminId()) || ( this.getAdminId()!=null && castOther.getAdminId()!=null && this.getAdminId().equals(castOther.getAdminId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAuthId() == null ? 0 : this.getAuthId().hashCode() );
         result = 37 * result + ( getAdminId() == null ? 0 : this.getAdminId().hashCode() );
         return result;
   }   





}