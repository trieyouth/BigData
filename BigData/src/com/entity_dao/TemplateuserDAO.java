package com.entity_dao;

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

/**
 	* A data access object (DAO) providing persistence and search support for Templateuser entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.entity_dao.Templateuser
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class TemplateuserDAO  {
	     private static final Logger log = LoggerFactory.getLogger(TemplateuserDAO.class);
		//property constants
	public static final String DATA_NUMBER = "dataNumber";



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
    
    public void save(Templateuser transientInstance) {
        log.debug("saving Templateuser instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Templateuser persistentInstance) {
        log.debug("deleting Templateuser instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Templateuser findById( com.entity_dao.TemplateuserId id) {
        log.debug("getting Templateuser instance with id: " + id);
        try {
            Templateuser instance = (Templateuser) getCurrentSession()
                    .get("com.entity.Templateuser", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Templateuser> findByExample(Templateuser instance) {
        log.debug("finding Templateuser instance by example");
        try {
            List<Templateuser> results = (List<Templateuser>) getCurrentSession() .createCriteria("com.entity.Templateuser").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Templateuser instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Templateuser as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Templateuser> findByDataNumber(Object dataNumber
	) {
		return findByProperty(DATA_NUMBER, dataNumber
		);
	}
	

	public List findAll() {
		log.debug("finding all Templateuser instances");
		try {
			String queryString = "from Templateuser";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Templateuser merge(Templateuser detachedInstance) {
        log.debug("merging Templateuser instance");
        try {
            Templateuser result = (Templateuser) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Templateuser instance) {
        log.debug("attaching dirty Templateuser instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Templateuser instance) {
        log.debug("attaching clean Templateuser instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TemplateuserDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TemplateuserDAO) ctx.getBean("TemplateuserDAO");
	}
}