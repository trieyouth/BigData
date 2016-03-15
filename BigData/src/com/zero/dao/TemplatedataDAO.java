package com.zero.dao;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistryBuilder;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.zero.entity.Templatedata;

/**
 	* A data access object (DAO) providing persistence and search support for Templatedata entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zero.entity.Templatedata
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class TemplatedataDAO  {
	     private static final Logger log = LoggerFactory.getLogger(TemplatedataDAO.class);
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
    
    public void save(Templatedata transientInstance) {
        log.debug("saving Templatedata instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Templatedata persistentInstance) {
        log.debug("deleting Templatedata instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
	public void deleteTempId(String tempId) {
		org.hibernate.cfg.Configuration cfg = new 
				org.hibernate.cfg.Configuration()
				.configure();
		SessionFactory factory = cfg
				.buildSessionFactory(new 
						ServiceRegistryBuilder().applySettings
						(cfg.getProperties()).buildServiceRegistry());
		Session session = factory.openSession();
		Query query = session
				.createQuery("delete TemplateData as A where A.tempId=?");
		query.setString(0, tempId);
		query.executeUpdate();
		session.beginTransaction().commit();
		session.close();
		factory.close();
	}
    public Templatedata findById( java.lang.Integer id) {
        log.debug("getting Templatedata instance with id: " + id);
        try {
            Templatedata instance = (Templatedata) getCurrentSession()
                    .get("com.zero.entity.Templatedata", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Templatedata> findByExample(Templatedata instance) {
        log.debug("finding Templatedata instance by example");
        try {
            List<Templatedata> results = (List<Templatedata>) getCurrentSession() .createCriteria("com.entity.Templatedata").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Templatedata instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Templatedata as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Templatedata> findByAdminId(Object adminId
	) {
		return findByProperty(ADMIN_ID, adminId
		);
	}
	

	public List findAll() {
		log.debug("finding all Templatedata instances");
		try {
			String queryString = "from Templatedata";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Templatedata merge(Templatedata detachedInstance) {
        log.debug("merging Templatedata instance");
        try {
            Templatedata result = (Templatedata) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Templatedata instance) {
        log.debug("attaching dirty Templatedata instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Templatedata instance) {
        log.debug("attaching clean Templatedata instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TemplatedataDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TemplatedataDAO) ctx.getBean("TemplatedataDAO");
	}
}