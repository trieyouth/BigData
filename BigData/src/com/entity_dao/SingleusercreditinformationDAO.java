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
 	* A data access object (DAO) providing persistence and search support for Singleusercreditinformation entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.entity_dao.Singleusercreditinformation
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class SingleusercreditinformationDAO  {
	     private static final Logger log = LoggerFactory.getLogger(SingleusercreditinformationDAO.class);
		//property constants
	public static final String USER_NAME = "userName";
	public static final String GENERATE_RECORD_NUM = "generateRecordNum";
	public static final String SELECT_OWING_TAXES = "selectOwingTaxes";
	public static final String ELECTRICITY_ARREARS = "electricityArrears";
	public static final String ADMINISTRATIVER_PUNISHMENT = "administrativerPunishment";
	public static final String ENFORCEMENT = "enforcement";
	public static final String CIVIL_JUDGMENT_RECORD = "civilJudgmentRecord";
	public static final String OWING_TAXES = "owingTaxes";
	public static final String HOUSE_LOAN = "houseLoan";
	public static final String LOANS_NUM = "loansNum";
	public static final String CREDIT_NUM = "creditNum";
	public static final String MONTHLY_INCOME = "monthlyIncome";
	public static final String AGE = "age";



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
    
    public void save(Singleusercreditinformation transientInstance) {
        log.debug("saving Singleusercreditinformation instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Singleusercreditinformation persistentInstance) {
        log.debug("deleting Singleusercreditinformation instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Singleusercreditinformation findById( java.lang.String id) {
        log.debug("getting Singleusercreditinformation instance with id: " + id);
        try {
            Singleusercreditinformation instance = (Singleusercreditinformation) getCurrentSession()
                    .get("com.entity.Singleusercreditinformation", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Singleusercreditinformation> findByExample(Singleusercreditinformation instance) {
        log.debug("finding Singleusercreditinformation instance by example");
        try {
            List<Singleusercreditinformation> results = (List<Singleusercreditinformation>) getCurrentSession() .createCriteria("com.entity.Singleusercreditinformation").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Singleusercreditinformation instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Singleusercreditinformation as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Singleusercreditinformation> findByUserName(Object userName
	) {
		return findByProperty(USER_NAME, userName
		);
	}
	
	public List<Singleusercreditinformation> findByGenerateRecordNum(Object generateRecordNum
	) {
		return findByProperty(GENERATE_RECORD_NUM, generateRecordNum
		);
	}
	
	public List<Singleusercreditinformation> findBySelectOwingTaxes(Object selectOwingTaxes
	) {
		return findByProperty(SELECT_OWING_TAXES, selectOwingTaxes
		);
	}
	
	public List<Singleusercreditinformation> findByElectricityArrears(Object electricityArrears
	) {
		return findByProperty(ELECTRICITY_ARREARS, electricityArrears
		);
	}
	
	public List<Singleusercreditinformation> findByAdministrativerPunishment(Object administrativerPunishment
	) {
		return findByProperty(ADMINISTRATIVER_PUNISHMENT, administrativerPunishment
		);
	}
	
	public List<Singleusercreditinformation> findByEnforcement(Object enforcement
	) {
		return findByProperty(ENFORCEMENT, enforcement
		);
	}
	
	public List<Singleusercreditinformation> findByCivilJudgmentRecord(Object civilJudgmentRecord
	) {
		return findByProperty(CIVIL_JUDGMENT_RECORD, civilJudgmentRecord
		);
	}
	
	public List<Singleusercreditinformation> findByOwingTaxes(Object owingTaxes
	) {
		return findByProperty(OWING_TAXES, owingTaxes
		);
	}
	
	public List<Singleusercreditinformation> findByHouseLoan(Object houseLoan
	) {
		return findByProperty(HOUSE_LOAN, houseLoan
		);
	}
	
	public List<Singleusercreditinformation> findByLoansNum(Object loansNum
	) {
		return findByProperty(LOANS_NUM, loansNum
		);
	}
	
	public List<Singleusercreditinformation> findByCreditNum(Object creditNum
	) {
		return findByProperty(CREDIT_NUM, creditNum
		);
	}
	
	public List<Singleusercreditinformation> findByMonthlyIncome(Object monthlyIncome
	) {
		return findByProperty(MONTHLY_INCOME, monthlyIncome
		);
	}
	
	public List<Singleusercreditinformation> findByAge(Object age
	) {
		return findByProperty(AGE, age
		);
	}
	

	public List findAll() {
		log.debug("finding all Singleusercreditinformation instances");
		try {
			String queryString = "from Singleusercreditinformation";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Singleusercreditinformation merge(Singleusercreditinformation detachedInstance) {
        log.debug("merging Singleusercreditinformation instance");
        try {
            Singleusercreditinformation result = (Singleusercreditinformation) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Singleusercreditinformation instance) {
        log.debug("attaching dirty Singleusercreditinformation instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Singleusercreditinformation instance) {
        log.debug("attaching clean Singleusercreditinformation instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static SingleusercreditinformationDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (SingleusercreditinformationDAO) ctx.getBean("SingleusercreditinformationDAO");
	}
}