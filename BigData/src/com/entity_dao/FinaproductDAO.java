package com.entity_dao;

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
 	* A data access object (DAO) providing persistence and search support for Finaproduct entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.entity_dao.Finaproduct
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class FinaproductDAO  {
	     private static final Logger log = LoggerFactory.getLogger(FinaproductDAO.class);
		//property constants
	public static final String PROD_CODE = "prodCode";
	public static final String PROD_NAME = "prodName";
	public static final String PROD_DETAIL = "prodDetail";
	public static final String RISK_LEVEL = "riskLevel";
	public static final String MINI_MONEY = "miniMoney";



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
    
    public void save(Finaproduct transientInstance) {
        log.debug("saving Finaproduct instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Finaproduct persistentInstance) {
        log.debug("deleting Finaproduct instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Finaproduct findById( java.lang.Integer id) {
        log.debug("getting Finaproduct instance with id: " + id);
        try {
            Finaproduct instance = (Finaproduct) getCurrentSession()
                    .get("com.entity.Finaproduct", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Finaproduct> findByExample(Finaproduct instance) {
        log.debug("finding Finaproduct instance by example");
        try {
            List<Finaproduct> results = (List<Finaproduct>) getCurrentSession() .createCriteria("com.entity.Finaproduct").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Finaproduct instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Finaproduct as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Finaproduct> findByProdCode(Object prodCode
	) {
		return findByProperty(PROD_CODE, prodCode
		);
	}
	
	public List<Finaproduct> findByProdName(Object prodName
	) {
		return findByProperty(PROD_NAME, prodName
		);
	}
	
	public List<Finaproduct> findByProdDetail(Object prodDetail
	) {
		return findByProperty(PROD_DETAIL, prodDetail
		);
	}
	
	public List<Finaproduct> findByRiskLevel(Object riskLevel
	) {
		return findByProperty(RISK_LEVEL, riskLevel
		);
	}
	
	public List<Finaproduct> findByMiniMoney(Object miniMoney
	) {
		return findByProperty(MINI_MONEY, miniMoney
		);
	}
	

	public List findAll() {
		log.debug("finding all Finaproduct instances");
		try {
			String queryString = "from Finaproduct";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Finaproduct merge(Finaproduct detachedInstance) {
        log.debug("merging Finaproduct instance");
        try {
            Finaproduct result = (Finaproduct) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Finaproduct instance) {
        log.debug("attaching dirty Finaproduct instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Finaproduct instance) {
        log.debug("attaching clean Finaproduct instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static FinaproductDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (FinaproductDAO) ctx.getBean("FinaproductDAO");
	}
}