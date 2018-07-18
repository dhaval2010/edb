package com.edb.samples;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Query;

/**
 * Provides API's for common lookup, update, save, delete and lookupAll
 * functionality.
 */
public class ApplicationDAOImpl<T> extends BaseDAO {

	private Class<T> type;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ApplicationDAOImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	static final String EmailIdQuery = "select Email_Id_SEQ.NEXTVAL from dual";
		
	public long EmailId(){
		Query query = em.createNativeQuery(EmailIdQuery);
		long sequence = ((BigInteger) query.getSingleResult()).longValue();
		return sequence;
	}
	
	public T lookup(final Object id) throws ApplicationException {
		return (T) this.em.find(type, id);
	}

	public void update(final T t) throws ApplicationException {
		try {
			this.em.merge(t);
		} catch (Exception e) {
			log.error("An error has occured while updating entity :" + type
					+ " : ");
			throw new ApplicationException(
					"An error has occured while updating: " + e.getMessage());
		}
	}

	public void save(T t) throws ApplicationException {
		try {
			this.em.persist(t);
		} catch (Exception e) {
			log.error("An error has occured while inserting entity :" + type
					+ " : " + e.getMessage());
			throw new ApplicationException(
					"An error has occured while inserting : ");
		}
	}

	public void delete(T t) throws ApplicationException {
		try {
			this.em.remove(this.em.getReference(type, t));
		} catch (Exception e) {
			log.error("An error has occured while deleting entity :" + type
					+ " : " + e.getMessage());
			throw new ApplicationException(
					"An error has occured while deleting : ");
		}
	}

	public void delete(Long t) throws ApplicationException {
		try {
			this.em.remove(this.em.getReference(type, t));
		} catch (Exception e) {
			log.error("An error has occured while deleting entity :" + type
					+ " : " + e.getMessage());
			throw new ApplicationException(
					"An error has occured while deleting : ");
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> lookupAll() throws ApplicationException {
		List<T> objects = null;
		try {
			Query query = em.createQuery("from " + type.getName());
			objects = query.getResultList();
		} catch (Exception e) {
			log.error("An error has occured while fetching entity :" + type
					+ " : " + e.getMessage());
			throw new ApplicationException(
					"An error has occured while fetching : ");
		}
		return objects;
	}

}