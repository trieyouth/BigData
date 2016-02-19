package com.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Adminrole;

/**
 	* A data access object (DAO) providing persistence and search support for Adminrole entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.entity.Adminrole
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class AdminroleDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AdminroleDAO.class);
		//property constants



    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
       this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
     return sessionFactory.getCurrentSession(); 
    }
	protected void initDao() {
		//do nothing
	}
    
    public void save(Adminrole transientInstance) {
        log.debug("saving Adminrole instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Adminrole persistentInstance) {
        log.debug("deleting Adminrole instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Adminrole findById( com.entity.AdminroleId id) {
        log.debug("getting Adminrole instance with id: " + id);
        try {
            Adminrole instance = (Adminrole) getCurrentSession()
                    .get("com.entity.Adminrole", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Adminrole> findByExample(Adminrole instance) {
        log.debug("finding Adminrole instance by example");
        try {
            List<Adminrole> results = (List<Adminrole>) getCurrentSession() .createCriteria("com.entity.Adminrole").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Adminrole instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Adminrole as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	public List findAll() {
		log.debug("finding all Adminrole instances");
		try {
			String queryString = "from Adminrole";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Adminrole merge(Adminrole detachedInstance) {
        log.debug("merging Adminrole instance");
        try {
            Adminrole result = (Adminrole) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Adminrole instance) {
        log.debug("attaching dirty Adminrole instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Adminrole instance) {
        log.debug("attaching clean Adminrole instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static AdminroleDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (AdminroleDAO) ctx.getBean("AdminroleDAO");
	}
}