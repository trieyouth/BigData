package com.zero.dao;

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

import com.zero.entity.Riskpreferencetemplatecontext;

/**
 	* A data access object (DAO) providing persistence and search support for Riskpreferencetemplatecontext entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zero.entity.Riskpreferencetemplatecontext
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class RiskpreferencetemplatecontextDAO  {
	     private static final Logger log = LoggerFactory.getLogger(RiskpreferencetemplatecontextDAO.class);
		//property constants
	public static final String MIN_AGE = "minAge";
	public static final String MAX_AGE = "maxAge";
	public static final String MIN_MONTHLY_INCOME = "minMonthlyIncome";
	public static final String MAX_MONTHLY_INCOME = "maxMonthlyIncome";
	public static final String MIN_PROPORTION_OF_INCOME = "minProportionOfIncome";
	public static final String MAX_PROPORTION_OF_INCOME = "maxProportionOfIncome";
	public static final String MIN_HISTORICAL_INVESTMENT = "minHistoricalInvestment";
	public static final String MAX_HISTORICAL_INVESTMENT = "maxHistoricalInvestment";
	public static final String MIN_HISTORICAL_INVESTMENT_SCOPE = "minHistoricalInvestmentScope";
	public static final String MAX_HISTORICAL_INVESTMENT_SCOPE = "maxHistoricalInvestmentScope";
	public static final String MIN_RESIDUAL_SCOPE_OF_DEPOSIT = "minResidualScopeOfDeposit";
	public static final String MAX_RESIDUAL_SCOPE_OF_DEPOSIT = "maxResidualScopeOfDeposit";
	public static final String MIN_LIST_OF_INVESTMENT_PRODUCTS = "minListOfInvestmentProducts";
	public static final String MAX_LIST_OF_INVESTMENT_PRODUCTS = "maxListOfInvestmentProducts";
	public static final String MIN_CUSTOMER_AGE_RANGE = "minCustomerAgeRange";
	public static final String MAX_CUSTOMER_AGE_RANGE = "maxCustomerAgeRange";
	public static final String MIN_CUSTOMER_INCOME_RANGE = "minCustomerIncomeRange";
	public static final String MAX_CUSTOMER_INCOME_RANGE = "maxCustomerIncomeRange";
	public static final String MIN_LIST_OF_CUSTOMERS_INDUSTRY = "minListOfCustomersIndustry";
	public static final String MAX_LIST_OF_CUSTOMERS_INDUSTRY = "maxListOfCustomersIndustry";
	public static final String GERENAL_RECORD = "gerenalRecord";



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
    
    public void save(Riskpreferencetemplatecontext transientInstance) {
        log.debug("saving Riskpreferencetemplatecontext instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Riskpreferencetemplatecontext persistentInstance) {
        log.debug("deleting Riskpreferencetemplatecontext instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Riskpreferencetemplatecontext findById( java.lang.Integer id) {
        log.debug("getting Riskpreferencetemplatecontext instance with id: " + id);
        try {
            Riskpreferencetemplatecontext instance = (Riskpreferencetemplatecontext) getCurrentSession()
                    .get("com.entity.Riskpreferencetemplatecontext", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Riskpreferencetemplatecontext> findByExample(Riskpreferencetemplatecontext instance) {
        log.debug("finding Riskpreferencetemplatecontext instance by example");
        try {
            List<Riskpreferencetemplatecontext> results = (List<Riskpreferencetemplatecontext>) getCurrentSession() .createCriteria("com.entity.Riskpreferencetemplatecontext").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Riskpreferencetemplatecontext instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Riskpreferencetemplatecontext as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Riskpreferencetemplatecontext> findByMinAge(Object minAge
	) {
		return findByProperty(MIN_AGE, minAge
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMaxAge(Object maxAge
	) {
		return findByProperty(MAX_AGE, maxAge
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMinMonthlyIncome(Object minMonthlyIncome
	) {
		return findByProperty(MIN_MONTHLY_INCOME, minMonthlyIncome
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMaxMonthlyIncome(Object maxMonthlyIncome
	) {
		return findByProperty(MAX_MONTHLY_INCOME, maxMonthlyIncome
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMinProportionOfIncome(Object minProportionOfIncome
	) {
		return findByProperty(MIN_PROPORTION_OF_INCOME, minProportionOfIncome
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMaxProportionOfIncome(Object maxProportionOfIncome
	) {
		return findByProperty(MAX_PROPORTION_OF_INCOME, maxProportionOfIncome
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMinHistoricalInvestment(Object minHistoricalInvestment
	) {
		return findByProperty(MIN_HISTORICAL_INVESTMENT, minHistoricalInvestment
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMaxHistoricalInvestment(Object maxHistoricalInvestment
	) {
		return findByProperty(MAX_HISTORICAL_INVESTMENT, maxHistoricalInvestment
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMinHistoricalInvestmentScope(Object minHistoricalInvestmentScope
	) {
		return findByProperty(MIN_HISTORICAL_INVESTMENT_SCOPE, minHistoricalInvestmentScope
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMaxHistoricalInvestmentScope(Object maxHistoricalInvestmentScope
	) {
		return findByProperty(MAX_HISTORICAL_INVESTMENT_SCOPE, maxHistoricalInvestmentScope
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMinResidualScopeOfDeposit(Object minResidualScopeOfDeposit
	) {
		return findByProperty(MIN_RESIDUAL_SCOPE_OF_DEPOSIT, minResidualScopeOfDeposit
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMaxResidualScopeOfDeposit(Object maxResidualScopeOfDeposit
	) {
		return findByProperty(MAX_RESIDUAL_SCOPE_OF_DEPOSIT, maxResidualScopeOfDeposit
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMinListOfInvestmentProducts(Object minListOfInvestmentProducts
	) {
		return findByProperty(MIN_LIST_OF_INVESTMENT_PRODUCTS, minListOfInvestmentProducts
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMaxListOfInvestmentProducts(Object maxListOfInvestmentProducts
	) {
		return findByProperty(MAX_LIST_OF_INVESTMENT_PRODUCTS, maxListOfInvestmentProducts
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMinCustomerAgeRange(Object minCustomerAgeRange
	) {
		return findByProperty(MIN_CUSTOMER_AGE_RANGE, minCustomerAgeRange
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMaxCustomerAgeRange(Object maxCustomerAgeRange
	) {
		return findByProperty(MAX_CUSTOMER_AGE_RANGE, maxCustomerAgeRange
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMinCustomerIncomeRange(Object minCustomerIncomeRange
	) {
		return findByProperty(MIN_CUSTOMER_INCOME_RANGE, minCustomerIncomeRange
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMaxCustomerIncomeRange(Object maxCustomerIncomeRange
	) {
		return findByProperty(MAX_CUSTOMER_INCOME_RANGE, maxCustomerIncomeRange
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMinListOfCustomersIndustry(Object minListOfCustomersIndustry
	) {
		return findByProperty(MIN_LIST_OF_CUSTOMERS_INDUSTRY, minListOfCustomersIndustry
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByMaxListOfCustomersIndustry(Object maxListOfCustomersIndustry
	) {
		return findByProperty(MAX_LIST_OF_CUSTOMERS_INDUSTRY, maxListOfCustomersIndustry
		);
	}
	
	public List<Riskpreferencetemplatecontext> findByGerenalRecord(Object gerenalRecord
	) {
		return findByProperty(GERENAL_RECORD, gerenalRecord
		);
	}
	

	public List findAll() {
		log.debug("finding all Riskpreferencetemplatecontext instances");
		try {
			String queryString = "from Riskpreferencetemplatecontext";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Riskpreferencetemplatecontext merge(Riskpreferencetemplatecontext detachedInstance) {
        log.debug("merging Riskpreferencetemplatecontext instance");
        try {
            Riskpreferencetemplatecontext result = (Riskpreferencetemplatecontext) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Riskpreferencetemplatecontext instance) {
        log.debug("attaching dirty Riskpreferencetemplatecontext instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Riskpreferencetemplatecontext instance) {
        log.debug("attaching clean Riskpreferencetemplatecontext instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RiskpreferencetemplatecontextDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RiskpreferencetemplatecontextDAO) ctx.getBean("RiskpreferencetemplatecontextDAO");
	}
}