package com.dealersocket.idsm.utility;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import io.swagger.v3.oas.annotations.Parameter;

public class PageHelper<DomainClass> {
	private static final int MAX_PAGESIZE = 200;

	Session session;

	private Map<String, Object> parameters = new TreeMap<>();

	public PageHelper(Session session) {
		this.session = session;
	}

	public PageHelper<DomainClass> addParameter(String key, Object value) {
		parameters.put(key, value);
		return this;
	}

	private static Pageable fixPageable(@Parameter(hidden=true) Pageable pageable) {
		if (pageable == null)
			return PageRequest.of(0, Integer.MAX_VALUE);

		if (pageable.getPageSize() > MAX_PAGESIZE) {
			return PageRequest.of(pageable.getPageNumber(), MAX_PAGESIZE, pageable.getSort());
		}

		return pageable;
	}

	public Page<DomainClass> fetchPageJPA(CriteriaBuilder b, CriteriaQuery select, Root r, @Parameter(hidden=true)  Pageable pageable) {
		pageable = fixPageable(pageable);
		List<Predicate> predicates = new ArrayList<>();
		if (select.getRestriction() != null)
			predicates.add(select.getRestriction());

		// Get the total count of records in the select query
		long totalCount = this.getCount(b, select, r);
        //System.out.println("Count of Records:::::::::::::::::"+totalCount);
		// Get the list of ids only
		List<String> idList = this.getListOfIds(b, select, r, pageable, totalCount);
		System.out.println("idList size::::::::::::::::::"+idList.size());
		Query query = session.createQuery(select);
		Page page = null;
		// fire the select query
		if (null != idList && !idList.isEmpty()) {
			CriteriaBuilder.In<String> inClause = b.in(r.get("id"));
			idList.stream().filter(e -> e != null).forEach(e -> inClause.value(e));
			predicates.add(inClause);
			// Set the root to get root objects
			select.select(r);
			// Add all the predicates
			select.where(predicates.toArray(new Predicate[0]));
			query = session.createQuery(select);
			for(int i=0;i<=query.getResultList().size()-1;i++) { 
			    System.out.println("Count of Records:::::::::::::::::"+query.getResultList().get(i).toString());
			}
			return new PageImpl<>(query.getResultList(), pageable, totalCount);
		}
		if (page == null) {
			page = new PageImpl<>(new ArrayList(), pageable, totalCount);
		}
		return page;
	}

	public long getCount(CriteriaBuilder b, CriteriaQuery counteQuery, Root r) {
		counteQuery.select(b.count(r));
		return (Long) session.createQuery(counteQuery).getSingleResult();
	}

	public List<String> getListOfIds(CriteriaBuilder b, CriteriaQuery q, Root r, Pageable pageable, long count) {
		// set the root to get list of Ids only
		CriteriaQuery<DomainClass> IdSlelect = q.select(r.get("id")
		// ).orderBy ( b.asc ( r.get ( "planId" ) )
		);
		Query idsQuery = session.createQuery(q);
		idsQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		idsQuery.setMaxResults(pageable.getPageSize());
		return new PageImpl<String>(idsQuery.getResultList(), pageable, count).getContent();
	}
}