package com.entity_dao;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * TemplateuserId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class TemplateuserId  implements java.io.Serializable {


    // Fields    

     private Integer adminId;
     private Integer tempId;


    // Constructors

    /** default constructor */
    public TemplateuserId() {
    }

    
    /** full constructor */
    public TemplateuserId(Integer adminId, Integer tempId) {
        this.adminId = adminId;
        this.tempId = tempId;
    }

   
    // Property accessors

    @Column(name="admin_id", nullable=false)

    public Integer getAdminId() {
        return this.adminId;
    }
    
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Column(name="temp_id", nullable=false)

    public Integer getTempId() {
        return this.tempId;
    }
    
    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TemplateuserId) ) return false;
		 TemplateuserId castOther = ( TemplateuserId ) other; 
         
		 return ( (this.getAdminId()==castOther.getAdminId()) || ( this.getAdminId()!=null && castOther.getAdminId()!=null && this.getAdminId().equals(castOther.getAdminId()) ) )
 && ( (this.getTempId()==castOther.getTempId()) || ( this.getTempId()!=null && castOther.getTempId()!=null && this.getTempId().equals(castOther.getTempId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAdminId() == null ? 0 : this.getAdminId().hashCode() );
         result = 37 * result + ( getTempId() == null ? 0 : this.getTempId().hashCode() );
         return result;
   }   





}