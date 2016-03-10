package com.zero.dao;

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

import com.zero.entity.Creditanalysistemplatecontext;

/**
 	* A data access object (DAO) providing persistence and search support for Creditanalysistemplatecontext entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zero.entity.Creditanalysistemplatecontext
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class CreditanalysistemplatecontextDAO  {
	     private static final Logger log = LoggerFactory.getLogger(CreditanalysistemplatecontextDAO.class);
		//property constants
	public static final String GENERATE_RECORD_NUM = "generateRecordNum";
	public static final String MAX_SELECT_OWING_TAXES = "maxSelectOwingTaxes";
	public static final String MIN_SELECT_OWING_TAXES = "minSelectOwingTaxes";
	public static final String MAXM_ELECTRICITY_ARREARS = "maxmElectricityArrears";
	public static final String MIN_ELECTRICITY_ARREARS = "minElectricityArrears";
	public static final String MAX_ADMINISTRATIVER_PUNISHMENT = "maxAdministrativerPunishment";
	public static final String MIN_ADMINISTRATIVER_PUNISHMENT = "minAdministrativerPunishment";
	public static final String MAX_ENFORCEMENT = "maxEnforcement";
	public static final String MIN_ENFORCEMENT = "minEnforcement";
	public static final String MAX_CIVIL_JUDGMENT_RECORD = "maxCivilJudgmentRecord";
	public static final String MIN_CIVIL_JUDGMENT_RECORD = "minCivilJudgmentRecord";
	public static final String MAX_OWING_TAXES = "maxOwingTaxes";
	public static final String MIN_OWING_TAXES = "minOwingTaxes";
	public static final String MAX_HOUSE_LOAN = "maxHouseLoan";
	public static final String MIN_HOUSE_LOAN = "minHouseLoan";
	public static final String MAX_LOANS_NUM = "maxLoansNum";
	public static final String MIN_LOANS_NUM = "minLoansNum";
	public static final String MAX_CREDIT_NUM = "maxCreditNum";
	public static final String MIN_CREDIT_NUM = "minCreditNum";
	public static final String MAX_MOUNTHLY_INCOME = "maxMounthlyIncome";
	public static final String MIN_MONTHLY_INCOME = "minMonthlyIncome";
	public static final String MAX_AGE = "maxAge";
	public static final String MIN_AGE = "minAge";



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
    
    public void save(Creditanalysistemplatecontext transientInstance) {
        log.debug("saving Creditanalysistemplatecontext instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Creditanalysistemplatecontext persistentInstance) {
        log.debug("deleting Creditanalysistemplatecontext instance");
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
				.createQuery("delete Creditanalysistemplatecontext as A where A.templateID=?");
		query.setString(0, tempId);
		query.executeUpdate();
		session.beginTransaction().commit();
		session.close();
		factory.close();
	}
    public Creditanalysistemplatecontext findById( java.lang.Integer id) {
        log.debug("getting Creditanalysistemplatecontext instance with id: " + id);
        try {
            Creditanalysistemplatecontext instance = (Creditanalysistemplatecontext) getCurrentSession()
                    .get("com.entity.Creditanalysistemplatecontext", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Creditanalysistemplatecontext> findByExample(Creditanalysistemplatecontext instance) {
        log.debug("finding Creditanalysistemplatecontext instance by example");
        try {
            List<Creditanalysistemplatecontext> results = (List<Creditanalysistemplatecontext>) getCurrentSession() .createCriteria("com.entity.Creditanalysistemplatecontext").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Creditanalysistemplatecontext instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Creditanalysistemplatecontext as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Creditanalysistemplatecontext> findByGenerateRecordNum(Object generateRecordNum
	) {
		return findByProperty(GENERATE_RECORD_NUM, generateRecordNum
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMaxSelectOwingTaxes(Object maxSelectOwingTaxes
	) {
		return findByProperty(MAX_SELECT_OWING_TAXES, maxSelectOwingTaxes
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMinSelectOwingTaxes(Object minSelectOwingTaxes
	) {
		return findByProperty(MIN_SELECT_OWING_TAXES, minSelectOwingTaxes
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMaxmElectricityArrears(Object maxmElectricityArrears
	) {
		return findByProperty(MAXM_ELECTRICITY_ARREARS, maxmElectricityArrears
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMinElectricityArrears(Object minElectricityArrears
	) {
		return findByProperty(MIN_ELECTRICITY_ARREARS, minElectricityArrears
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMaxAdministrativerPunishment(Object maxAdministrativerPunishment
	) {
		return findByProperty(MAX_ADMINISTRATIVER_PUNISHMENT, maxAdministrativerPunishment
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMinAdministrativerPunishment(Object minAdministrativerPunishment
	) {
		return findByProperty(MIN_ADMINISTRATIVER_PUNISHMENT, minAdministrativerPunishment
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMaxEnforcement(Object maxEnforcement
	) {
		return findByProperty(MAX_ENFORCEMENT, maxEnforcement
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMinEnforcement(Object minEnforcement
	) {
		return findByProperty(MIN_ENFORCEMENT, minEnforcement
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMaxCivilJudgmentRecord(Object maxCivilJudgmentRecord
	) {
		return findByProperty(MAX_CIVIL_JUDGMENT_RECORD, maxCivilJudgmentRecord
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMinCivilJudgmentRecord(Object minCivilJudgmentRecord
	) {
		return findByProperty(MIN_CIVIL_JUDGMENT_RECORD, minCivilJudgmentRecord
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMaxOwingTaxes(Object maxOwingTaxes
	) {
		return findByProperty(MAX_OWING_TAXES, maxOwingTaxes
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMinOwingTaxes(Object minOwingTaxes
	) {
		return findByProperty(MIN_OWING_TAXES, minOwingTaxes
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMaxHouseLoan(Object maxHouseLoan
	) {
		return findByProperty(MAX_HOUSE_LOAN, maxHouseLoan
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMinHouseLoan(Object minHouseLoan
	) {
		return findByProperty(MIN_HOUSE_LOAN, minHouseLoan
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMaxLoansNum(Object maxLoansNum
	) {
		return findByProperty(MAX_LOANS_NUM, maxLoansNum
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMinLoansNum(Object minLoansNum
	) {
		return findByProperty(MIN_LOANS_NUM, minLoansNum
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMaxCreditNum(Object maxCreditNum
	) {
		return findByProperty(MAX_CREDIT_NUM, maxCreditNum
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMinCreditNum(Object minCreditNum
	) {
		return findByProperty(MIN_CREDIT_NUM, minCreditNum
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMaxMounthlyIncome(Object maxMounthlyIncome
	) {
		return findByProperty(MAX_MOUNTHLY_INCOME, maxMounthlyIncome
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMinMonthlyIncome(Object minMonthlyIncome
	) {
		return findByProperty(MIN_MONTHLY_INCOME, minMonthlyIncome
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMaxAge(Object maxAge
	) {
		return findByProperty(MAX_AGE, maxAge
		);
	}
	
	public List<Creditanalysistemplatecontext> findByMinAge(Object minAge
	) {
		return findByProperty(MIN_AGE, minAge
		);
	}
	

	public List findAll() {
		log.debug("finding all Creditanalysistemplatecontext instances");
		try {
			String queryString = "from Creditanalysistemplatecontext";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Creditanalysistemplatecontext merge(Creditanalysistemplatecontext detachedInstance) {
        log.debug("merging Creditanalysistemplatecontext instance");
        try {
            Creditanalysistemplatecontext result = (Creditanalysistemplatecontext) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Creditanalysistemplatecontext instance) {
        log.debug("attaching dirty Creditanalysistemplatecontext instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Creditanalysistemplatecontext instance) {
        log.debug("attaching clean Creditanalysistemplatecontext instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static CreditanalysistemplatecontextDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (CreditanalysistemplatecontextDAO) ctx.getBean("CreditanalysistemplatecontextDAO");
	}
}