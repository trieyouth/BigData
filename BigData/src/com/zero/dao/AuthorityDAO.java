package com.zero.dao;

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

import com.zero.entity.Authority;

/**
 	* A data access object (DAO) providing persistence and search support for Authority entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zero.entity.Authority
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class AuthorityDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AuthorityDAO.class);
		//property constants
	public static final String AUTH_NAME = "authName";



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
    
    public void save(Authority transientInstance) {
        log.debug("saving Authority instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Authority persistentInstance) {
        log.debug("deleting Authority instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Authority findById( java.lang.Integer id) {
        log.debug("getting Authority instance with id: " + id);
        try {
            Authority instance = (Authority) getCurrentSession()
                    .get("com.entity.Authority", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Authority> findByExample(Authority instance) {
        log.debug("finding Authority instance by example");
        try {
            List<Authority> results = (List<Authority>) getCurrentSession() .createCriteria("com.entity.Authority").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Authority instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Authority as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Authority> findByAuthName(Object authName
	) {
		return findByProperty(AUTH_NAME, authName
		);
	}
	

	public List findAll() {
		log.debug("finding all Authority instances");
		try {
			String queryString = "from Authority";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Authority merge(Authority detachedInstance) {
        log.debug("merging Authority instance");
        try {
            Authority result = (Authority) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Authority instance) {
        log.debug("attaching dirty Authority instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Authority instance) {
        log.debug("attaching clean Authority instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static AuthorityDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (AuthorityDAO) ctx.getBean("AuthorityDAO");
	}
}