package com.entity_dao;

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
 	* A data access object (DAO) providing persistence and search support for Adminuser entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.entity_dao.Adminuser
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class AdminuserDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AdminuserDAO.class);
		//property constants
	public static final String ADMIN_NAME = "adminName";
	public static final String ADMIN_TITLE = "adminTitle";
	public static final String ADMIN_PASSWD = "adminPasswd";



    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
       this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
    	Session session = sessionFactory.getCurrentSession();
    	if(session == null){
    		log.info("session == null");
    	}
    	return session; 
    }
    
	protected void initDao() {
		//do nothing
	}
    
    public void save(Adminuser transientInstance) {
        log.debug("saving Adminuser instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Adminuser persistentInstance) {
        log.debug("deleting Adminuser instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Adminuser findById( java.lang.Integer id) {
        log.debug("getting Adminuser instance with id: " + id);
        try {
            Adminuser instance = (Adminuser) getCurrentSession()
                    .get("com.entity.Adminuser", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Adminuser> findByExample(Adminuser instance) {
        log.debug("finding Adminuser instance by example");
        try {
            List<Adminuser> results = (List<Adminuser>) getCurrentSession() .createCriteria("com.entity.Adminuser").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Adminuser instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Adminuser as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Adminuser> findByAdminName(Object adminName
	) {
		return findByProperty(ADMIN_NAME, adminName
		);
	}
	
	public List<Adminuser> findByAdminTitle(Object adminTitle
	) {
		return findByProperty(ADMIN_TITLE, adminTitle
		);
	}
	
	public List<Adminuser> findByAdminPasswd(Object adminPasswd
	) {
		return findByProperty(ADMIN_PASSWD, adminPasswd
		);
	}
	

	public List findAll() {
		log.debug("finding all Adminuser instances");
		try {
			String queryString = "from Adminuser";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Adminuser merge(Adminuser detachedInstance) {
        log.debug("merging Adminuser instance");
        try {
            Adminuser result = (Adminuser) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Adminuser instance) {
        log.debug("attaching dirty Adminuser instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Adminuser instance) {
        log.debug("attaching clean Adminuser instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static AdminuserDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (AdminuserDAO) ctx.getBean("AdminuserDAO");
	}
}