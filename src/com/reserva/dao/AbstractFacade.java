package com.reserva.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractFacade<T> {
	private Class<T>entityClass;
	protected abstract EntityManager getEntityManager();
	
	public AbstractFacade(Class<T> entityClass) {
		super();
		this.entityClass = entityClass;
	}
	
	public boolean create(T entity) {
		EntityManager em = getEntityManager();
		Boolean flag = false;
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			if (em.isOpen() && em.getTransaction() == null) {
				em.getTransaction().rollback();
			}
		}
		finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		return flag;
	}
	
	public void update(T entity) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction() == null && em.isOpen()) {
				em.getTransaction().rollback();
			}
		}
		finally {
			if (em.isOpen() && em != null) {
				em.close();
			}
		}
	}
	
	public void delete(T entity) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.isOpen() && em.getTransaction() == null) {
				em.getTransaction().rollback();
			}
		}
		finally {
			if (em.isOpen() && em != null) {
				em.close();
			}
		}
	}
	
	public T findId(Object id) {
		return getEntityManager().find(entityClass, id);
	}
	
	public List<T>mostrar(){
		CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
		return getEntityManager().createQuery(cq).getResultList();
	}
	
}
