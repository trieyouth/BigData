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

import com.entity.Creditratingclassification;

/**
 	* A data access object (DAO) providing persistence and search support for Creditratingclassification entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.entity.Creditratingclassification
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class CreditratingclassificationDAO  {
	     private static final Logger log = LoggerFactory.getLogger(CreditratingclassificationDAO.class);
		//property constants
	public static final String SCORE = "score";
	public static final String GRADE = "grade";
	public static final String CREDIT_RECORD = "creditRecord";
	public static final String CREDIT_ABILITY = "creditAbility";
	public static final String DEGREE_OF_RISK = "degreeOfRisk";
	public static final String NUMBER_OF_USERS = "numberOfUsers";



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
    
    public void save(Creditratingclassification transientInstance) {
        log.debug("saving Creditratingclassification instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Creditratingclassification persistentInstance) {
        log.debug("deleting Creditratingclassification instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Creditratingclassification findById( java.lang.Integer id) {
        log.debug("getting Creditratingclassification instance with id: " + id);
        try {
            Creditratingclassification instance = (Creditratingclassification) getCurrentSession()
                    .get("com.entity.Creditratingclassification", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Creditratingclassification> findByExample(Creditratingclassification instance) {
        log.debug("finding Creditratingclassification instance by example");
        try {
            List<Creditratingclassification> results = (List<Creditratingclassification>) getCurrentSession() .createCriteria("com.entity.Creditratingclassification").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Creditratingclassification instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Creditratingclassification as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Creditratingclassification> findByScore(Object score
	) {
		return findByProperty(SCORE, score
		);
	}
	
	public List<Creditratingclassification> findByGrade(Object grade
	) {
		return findByProperty(GRADE, grade
		);
	}
	
	public List<Creditratingclassification> findByCreditRecord(Object creditRecord
	) {
		return findByProperty(CREDIT_RECORD, creditRecord
		);
	}
	
	public List<Creditratingclassification> findByCreditAbility(Object creditAbility
	) {
		return findByProperty(CREDIT_ABILITY, creditAbility
		);
	}
	
	public List<Creditratingclassification> findByDegreeOfRisk(Object degreeOfRisk
	) {
		return findByProperty(DEGREE_OF_RISK, degreeOfRisk
		);
	}
	
	public List<Creditratingclassification> findByNumberOfUsers(Object numberOfUsers
	) {
		return findByProperty(NUMBER_OF_USERS, numberOfUsers
		);
	}
	

	public List findAll() {
		log.debug("finding all Creditratingclassification instances");
		try {
			String queryString = "from Creditratingclassification";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Creditratingclassification merge(Creditratingclassification detachedInstance) {
        log.debug("merging Creditratingclassification instance");
        try {
            Creditratingclassification result = (Creditratingclassification) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Creditratingclassification instance) {
        log.debug("attaching dirty Creditratingclassification instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Creditratingclassification instance) {
        log.debug("attaching clean Creditratingclassification instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static CreditratingclassificationDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (CreditratingclassificationDAO) ctx.getBean("CreditratingclassificationDAO");
	}
}