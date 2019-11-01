package com.reserva.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	private static final String UNIDAD_DE_PERSISTENCIA ="WebServiceRest";
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(UNIDAD_DE_PERSISTENCIA);
		}
		return factory;
	}
}
