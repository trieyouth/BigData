package com.dao;

import java.sql.Time;
import java.util.Date;
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

import com.entity.Secondtemplatedata;

/**
 	* A data access object (DAO) providing persistence and search support for Secondtemplatedata entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.entity.Secondtemplatedata
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class SecondtemplatedataDAO  {
	     private static final Logger log = LoggerFactory.getLogger(SecondtemplatedataDAO.class);
		//property constants
	public static final String ADMIN_ID = "adminId";



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
    
    public void save(Secondtemplatedata transientInstance) {
        log.debug("saving Secondtemplatedata instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Secondtemplatedata persistentInstance) {
        log.debug("deleting Secondtemplatedata instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Secondtemplatedata findById( java.lang.Integer id) {
        log.debug("getting Secondtemplatedata instance with id: " + id);
        try {
            Secondtemplatedata instance = (Secondtemplatedata) getCurrentSession()
                    .get("com.entity.Secondtemplatedata", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Secondtemplatedata> findByExample(Secondtemplatedata instance) {
        log.debug("finding Secondtemplatedata instance by example");
        try {
            List<Secondtemplatedata> results = (List<Secondtemplatedata>) getCurrentSession() .createCriteria("com.entity.Secondtemplatedata").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Secondtemplatedata instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Secondtemplatedata as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Secondtemplatedata> findByAdminId(Object adminId
	) {
		return findByProperty(ADMIN_ID, adminId
		);
	}
	

	public List findAll() {
		log.debug("finding all Secondtemplatedata instances");
		try {
			String queryString = "from Secondtemplatedata";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Secondtemplatedata merge(Secondtemplatedata detachedInstance) {
        log.debug("merging Secondtemplatedata instance");
        try {
            Secondtemplatedata result = (Secondtemplatedata) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Secondtemplatedata instance) {
        log.debug("attaching dirty Secondtemplatedata instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Secondtemplatedata instance) {
        log.debug("attaching clean Secondtemplatedata instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static SecondtemplatedataDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (SecondtemplatedataDAO) ctx.getBean("SecondtemplatedataDAO");
	}
}