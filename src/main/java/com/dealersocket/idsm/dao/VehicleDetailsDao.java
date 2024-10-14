package com.dealersocket.idsm.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
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
			
}