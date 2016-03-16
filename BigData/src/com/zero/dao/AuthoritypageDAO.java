package com.zero.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistryBuilder;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.zero.entity.Authoritypage;

/**
 	* A data access object (DAO) providing persistence and search support for Authoritypage entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zero.entity.Authoritypage
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class AuthoritypageDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AuthoritypageDAO.class);
		//property constants
	public static final String AUTH_ID = "authId";
	public static final String PAGE_URL = "pageUrl";
	public static final String PAGE_NAME = "pageName";



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
    
    public void save(Authoritypage transientInstance) {
        log.debug("saving Authoritypage instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Authoritypage persistentInstance) {
        log.debug("deleting Authoritypage instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Authoritypage findById( java.lang.Integer id) {
        log.debug("getting Authoritypage instance with id: " + id);
        try {
            Authoritypage instance = (Authoritypage) getCurrentSession()
                    .get("com.zero.entity.Authoritypage", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Authoritypage> findByExample(Authoritypage instance) {
        log.debug("finding Authoritypage instance by example");
        try {
            List<Authoritypage> results = (List<Authoritypage>) getCurrentSession() .createCriteria("com.entity.Authoritypage").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Authoritypage instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Authoritypage as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Authoritypage> findByAuthId(Object authId
	) {
		return findByProperty(AUTH_ID, authId
		);
	}
	
	public List<Authoritypage> findByPageUrl(Object pageUrl
	) {
		return findByProperty(PAGE_URL, pageUrl
		);
	}
	
	public List<Authoritypage> findByPageName(Object pageName
	) {
		return findByProperty(PAGE_NAME, pageName
		);
	}
	

	public List findAll() {
		log.debug("finding all Authoritypage instances");
		try {
			String queryString = "from Authoritypage";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<Authoritypage> findAuthorityPage(int authId,int pageId) {
		Session session = getCurrentSession();
		Criteria ctiteria =session.createCriteria(Authoritypage.class);
		ctiteria.add(Restrictions.eq("authId",authId));
		ctiteria.add(Restrictions.eq("pageId",pageId));
		return ctiteria.list();
	}
	
	public void deleteByAuthId(String authId) {
		Session session = getCurrentSession();
		Query query = session
				.createQuery("delete AuthorityPage as A where A.authId=?");
		query.setString(0, authId);
		query.executeUpdate();
		session.beginTransaction().commit();
	}
	
    public Authoritypage merge(Authoritypage detachedInstance) {
        log.debug("merging Authoritypage instance");
        try {
            Authoritypage result = (Authoritypage) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Authoritypage instance) {
        log.debug("attaching dirty Authoritypage instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Authoritypage instance) {
        log.debug("attaching clean Authoritypage instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static AuthoritypageDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (AuthoritypageDAO) ctx.getBean("AuthoritypageDAO");
	}
}