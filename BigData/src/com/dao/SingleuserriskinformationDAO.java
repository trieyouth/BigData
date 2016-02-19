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

import com.entity.Singleuserriskinformation;

/**
 	* A data access object (DAO) providing persistence and search support for Singleuserriskinformation entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.entity.Singleuserriskinformation
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class SingleuserriskinformationDAO  {
	     private static final Logger log = LoggerFactory.getLogger(SingleuserriskinformationDAO.class);
		//property constants
	public static final String USERNAME = "username";
	public static final String AGE = "age";
	public static final String MONTHLY_INCOME = "monthlyIncome";
	public static final String PROPORTION_OF_INCOME = "proportionOfIncome";
	public static final String HISTORICAL_INVESTMENT = "historicalInvestment";
	public static final String HISTORICAL_INVESTMENT_SCOPE = "historicalInvestmentScope";
	public static final String RESIDUAL_SCOPE_OF_DEPOSIT = "residualScopeOfDeposit";
	public static final String LIST_OF_INVESTMENT_PRODUCTS = "listOfInvestmentProducts";
	public static final String CUSTOMER_AGE_RANGE = "customerAgeRange";
	public static final String CUSTOMER_INCOME_RANGE = "customerIncomeRange";
	public static final String LIST_OF_CUSTOMERS_INDUSTRY = "listOfCustomersIndustry";



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
    
    public void save(Singleuserriskinformation transientInstance) {
        log.debug("saving Singleuserriskinformation instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Singleuserriskinformation persistentInstance) {
        log.debug("deleting Singleuserriskinformation instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Singleuserriskinformation findById( java.lang.String id) {
        log.debug("getting Singleuserriskinformation instance with id: " + id);
        try {
            Singleuserriskinformation instance = (Singleuserriskinformation) getCurrentSession()
                    .get("com.entity.Singleuserriskinformation", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Singleuserriskinformation> findByExample(Singleuserriskinformation instance) {
        log.debug("finding Singleuserriskinformation instance by example");
        try {
            List<Singleuserriskinformation> results = (List<Singleuserriskinformation>) getCurrentSession() .createCriteria("com.entity.Singleuserriskinformation").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Singleuserriskinformation instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Singleuserriskinformation as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Singleuserriskinformation> findByUsername(Object username
	) {
		return findByProperty(USERNAME, username
		);
	}
	
	public List<Singleuserriskinformation> findByAge(Object age
	) {
		return findByProperty(AGE, age
		);
	}
	
	public List<Singleuserriskinformation> findByMonthlyIncome(Object monthlyIncome
	) {
		return findByProperty(MONTHLY_INCOME, monthlyIncome
		);
	}
	
	public List<Singleuserriskinformation> findByProportionOfIncome(Object proportionOfIncome
	) {
		return findByProperty(PROPORTION_OF_INCOME, proportionOfIncome
		);
	}
	
	public List<Singleuserriskinformation> findByHistoricalInvestment(Object historicalInvestment
	) {
		return findByProperty(HISTORICAL_INVESTMENT, historicalInvestment
		);
	}
	
	public List<Singleuserriskinformation> findByHistoricalInvestmentScope(Object historicalInvestmentScope
	) {
		return findByProperty(HISTORICAL_INVESTMENT_SCOPE, historicalInvestmentScope
		);
	}
	
	public List<Singleuserriskinformation> findByResidualScopeOfDeposit(Object residualScopeOfDeposit
	) {
		return findByProperty(RESIDUAL_SCOPE_OF_DEPOSIT, residualScopeOfDeposit
		);
	}
	
	public List<Singleuserriskinformation> findByListOfInvestmentProducts(Object listOfInvestmentProducts
	) {
		return findByProperty(LIST_OF_INVESTMENT_PRODUCTS, listOfInvestmentProducts
		);
	}
	
	public List<Singleuserriskinformation> findByCustomerAgeRange(Object customerAgeRange
	) {
		return findByProperty(CUSTOMER_AGE_RANGE, customerAgeRange
		);
	}
	
	public List<Singleuserriskinformation> findByCustomerIncomeRange(Object customerIncomeRange
	) {
		return findByProperty(CUSTOMER_INCOME_RANGE, customerIncomeRange
		);
	}
	
	public List<Singleuserriskinformation> findByListOfCustomersIndustry(Object listOfCustomersIndustry
	) {
		return findByProperty(LIST_OF_CUSTOMERS_INDUSTRY, listOfCustomersIndustry
		);
	}
	

	public List findAll() {
		log.debug("finding all Singleuserriskinformation instances");
		try {
			String queryString = "from Singleuserriskinformation";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Singleuserriskinformation merge(Singleuserriskinformation detachedInstance) {
        log.debug("merging Singleuserriskinformation instance");
        try {
            Singleuserriskinformation result = (Singleuserriskinformation) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Singleuserriskinformation instance) {
        log.debug("attaching dirty Singleuserriskinformation instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Singleuserriskinformation instance) {
        log.debug("attaching clean Singleuserriskinformation instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static SingleuserriskinformationDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (SingleuserriskinformationDAO) ctx.getBean("SingleuserriskinformationDAO");
	}
}