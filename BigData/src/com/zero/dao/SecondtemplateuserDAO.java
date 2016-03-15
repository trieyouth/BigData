package com.zero.dao;

import java.sql.Time;
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

import com.zero.entity.Secondtemplateuser;

/**
 * A data access object (DAO) providing persistence and search support for
 * Secondtemplateuser entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.zero.entity.Secondtemplateuser
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SecondtemplateuserDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SecondtemplateuserDAO.class);
	// property constants
	public static final String ADMIN_ID = "adminId";
	public static final String DATA_NUMBER = "dataNumber";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Secondtemplateuser transientInstance) {
		log.debug("saving Secondtemplateuser instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Secondtemplateuser persistentInstance) {
		log.debug("deleting Secondtemplateuser instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Secondtemplateuser findById(java.lang.Integer id) {
		log.debug("getting Secondtemplateuser instance with id: " + id);
		try {
			Secondtemplateuser instance = (Secondtemplateuser) getCurrentSession()
					.get("com.zero.entity.Secondtemplateuser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Secondtemplateuser> findByExample(Secondtemplateuser instance) {
		log.debug("finding Secondtemplateuser instance by example");
		try {
			List<Secondtemplateuser> results = (List<Secondtemplateuser>) getCurrentSession()
					.createCriteria("com.zero.entity.Secondtemplateuser")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Secondtemplateuser instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Secondtemplateuser as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Secondtemplateuser> findByAdminId(Object adminId) {
		return findByProperty(ADMIN_ID, adminId);
	}

	public List<Secondtemplateuser> findByDataNumber(Object dataNumber) {
		return findByProperty(DATA_NUMBER, dataNumber);
	}

	public List findAll() {
		log.debug("finding all Secondtemplateuser instances");
		try {
			String queryString = "from Secondtemplateuser";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Secondtemplateuser merge(Secondtemplateuser detachedInstance) {
		log.debug("merging Secondtemplateuser instance");
		try {
			Secondtemplateuser result = (Secondtemplateuser) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Secondtemplateuser instance) {
		log.debug("attaching dirty Secondtemplateuser instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Secondtemplateuser instance) {
		log.debug("attaching clean Secondtemplateuser instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SecondtemplateuserDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (SecondtemplateuserDAO) ctx.getBean("SecondtemplateuserDAO");
	}
}