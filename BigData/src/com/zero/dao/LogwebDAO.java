package com.zero.dao;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zero.entity.Logweb;

/**
 	* A data access object (DAO) providing persistence and search support for Logweb entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zero.entity.Logweb
  * @author MyEclipse Persistence Tools 
 */
@Repository(value="LogwebDAO")
@Transactional   
public class LogwebDAO  {
	     private static final Logger log = LoggerFactory.getLogger(LogwebDAO.class);
		//property constants
	public static final String ADMIN_ID = "adminId";
	public static final String LOG_CONTEN = "logConten";


	@Autowired
    private SessionFactory sessionFactory;
	
	@Resource
    public void setSessionFactory(SessionFactory sessionFactory){
       this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
     return sessionFactory.getCurrentSession(); 
    }
	protected void initDao() {
		//do nothing
	}
    
    public void save(Logweb transientInstance) {
        log.debug("saving Logweb instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Logweb persistentInstance) {
        log.debug("deleting Logweb instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Logweb findById( java.lang.Long id) {
        log.debug("getting Logweb instance with id: " + id);
        try {
            Logweb instance = (Logweb) getCurrentSession()
                    .get("com.entity.Logweb", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Logweb> findByExample(Logweb instance) {
        log.debug("finding Logweb instance by example");
        try {
            List<Logweb> results = (List<Logweb>) getCurrentSession() .createCriteria("com.entity.Logweb").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Logweb instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Logweb as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Logweb> findByAdminId(Object adminId
	) {
		return findByProperty(ADMIN_ID, adminId
		);
	}
	
	public List<Logweb> findByLogConten(Object logConten
	) {
		return findByProperty(LOG_CONTEN, logConten
		);
	}
	

	public List findAll() {
		log.debug("finding all Logweb instances");
		try {
			String queryString = "from Logweb";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Logweb merge(Logweb detachedInstance) {
        log.debug("merging Logweb instance");
        try {
            Logweb result = (Logweb) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Logweb instance) {
        log.debug("attaching dirty Logweb instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Logweb instance) {
        log.debug("attaching clean Logweb instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static LogwebDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (LogwebDAO) ctx.getBean("LogwebDAO");
	}
}