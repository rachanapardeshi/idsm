package com.dealersocket.idsm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.dealersocket.idsm.model.VehicleDetailsModel;
import com.dealersocket.idsm.utility.PageHelper;

import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component
@Repository
@Transactional
@EnableTransactionManagement
public class VehicleDetailsDao {
	private static final Logger logger = LoggerFactory.getLogger(VehicleDetailsDao.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private EntityManager entityManager;

	public void insertVehicleDetails(VehicleDetailsModel vh) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(vh);
		session.refresh(vh);
	}

	public Page<VehicleDetailsModel> getVehicleDetails(@Parameter(hidden=true)  Pageable pageable) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<VehicleDetailsModel> criteriaQuery = cb.createQuery(VehicleDetailsModel.class);
		Root<VehicleDetailsModel> root = criteriaQuery.from(VehicleDetailsModel.class);
		CriteriaQuery<VehicleDetailsModel> select = criteriaQuery.select(root).orderBy(cb.asc(root.get("id")));
		//Query<AccountType> q = session.createQuery(select);
		//return q.getResultList();
		return new PageHelper<VehicleDetailsModel>(session).fetchPageJPA(cb, select, root, pageable);
	}

	public List<VehicleDetailsModel> listVehicles() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<VehicleDetailsModel> criteriaQuery = cb.createQuery(VehicleDetailsModel.class);
		Root<VehicleDetailsModel> root = criteriaQuery.from(VehicleDetailsModel.class);
		CriteriaQuery<VehicleDetailsModel> select = criteriaQuery.select(root).orderBy(cb.asc(root.get("id")));
		Query<VehicleDetailsModel> query = session.createQuery(select);	
		return query.getResultList();
	}

	//-------------------------------------------------------------------------------------
	// Method to validate and save account
	public void saveAccount(VehicleDetailsModel account) {
		try {
			Session session = sessionFactory.getCurrentSession();
			if (isDuplicateAcctID(account.getAcctID())) {
				//logger.info("Duplicate AccountID found, skipping "+account.getAcctID());
				throw new IllegalArgumentException("Duplicate AcctID: " + account.getAcctID());
			}
			session.save(account);
		}
		catch (IllegalArgumentException e) {
			logger.info("Duplicate AccountID found, skipping "+account.getAcctID());
		}
	}

	// Method using CriteriaBuilder to check for duplicates
	private boolean isDuplicateAcctID(String acctID) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> query = cb.createQuery(Long.class);
		Root<VehicleDetailsModel> accountRoot = query.from(VehicleDetailsModel.class);

		query.select(cb.count(accountRoot)).where(cb.equal(accountRoot.get("acctID"), acctID));

		// Execute the query and get the result
		Long count = entityManager.createQuery(query).getSingleResult();
		return count > 0;
	}


}