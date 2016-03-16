package com.zero.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.zero.entity.Adimauthority;
import com.zero.entity.AdimauthorityId;

/**
 	* A data access object (DAO) providing persistence and search support for Adimauthority entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zero.entity.Adimauthority
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class AdimauthorityDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AdimauthorityDAO.class);
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
    
    public void save(Adimauthority transientInstance) {
        log.debug("saving Adimauthority instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Adimauthority persistentInstance) {
        log.debug("deleting Adimauthority instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Adimauthority findById( com.zero.entity.AdimauthorityId id) {
        log.debug("getting Adimauthority instance with id: " + id);
        try {
            Adimauthority instance = (Adimauthority) getCurrentSession()
                    .get("com.zero.entity.Adimauthority", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Adimauthority> findByExample(Adimauthority instance) {
        log.debug("finding Adimauthority instance by example");
        try {
            List<Adimauthority> results = (List<Adimauthority>) getCurrentSession() .createCriteria("com.entity.Adimauthority").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Adimauthority instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Adimauthority as model where model." 
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
		log.debug("finding all Adimauthority instances");
		try {
			String queryString = "from Adimauthority";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	//��ӵ�
	public List findAuthId(int adminId) {
		Session session = getCurrentSession();
		Criteria criteria=session.createCriteria(Adimauthority.class);
		criteria.add(Restrictions.eq("id.adminId",adminId)); 
		return criteria.list();
	}
	
	//��ӵ�
	public void deleteByAuthId(int adminId,int oldauthid) {
		Session session = getCurrentSession();
		AdimauthorityId tempAdimAuthorityId=new AdimauthorityId(oldauthid,adminId);
		Adimauthority tempAdimAuthority=(Adimauthority)session.load(Adimauthority.class, tempAdimAuthorityId);
		session.delete(tempAdimAuthority);
	}
	
    public Adimauthority merge(Adimauthority detachedInstance) {
        log.debug("merging Adimauthority instance");
        try {
            Adimauthority result = (Adimauthority) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Adimauthority instance) {
        log.debug("attaching dirty Adimauthority instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Adimauthority instance) {
        log.debug("attaching clean Adimauthority instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static AdimauthorityDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (AdimauthorityDAO) ctx.getBean("AdimauthorityDAO");
	}
}