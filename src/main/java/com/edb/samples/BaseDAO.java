package com.edb.samples;

import java.io.Closeable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

/**
 * Provides API's for common lookup, update, save, delete and lookupAll
 * functionality.
 */
public abstract class BaseDAO {

	@Inject
	protected EntityManager em;

	@Inject
	protected Logger log;
		
	protected boolean cleanup(Closeable resource)
	{
	  try{
	    if(resource!=null)
	    {
	 	   resource.close();
		   return true;
	    }
	    else 	
		   return false;
	  }catch(Exception e){
	    return false;
	  }
	}
	
	protected boolean cleanup(AutoCloseable resource)
	{
	  try{
	    if(resource!=null)
	    {
	 	   resource.close();
		   return true;
	    }
	    else 	
		   return false;
	  }catch(Exception e){
	    return false;
	  }
	}

}