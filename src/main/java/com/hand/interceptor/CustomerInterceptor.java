package com.hand.interceptor;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import com.hand.javabean.Customer;

public class CustomerInterceptor extends EmptyInterceptor {


	   public void onDelete(Object entity,
	                     Serializable id,
	                     Object[] state,
	                     String[] propertyNames,
	                     Type[] types) {
	       // do nothing
	   }

	   // This method is called when Employee object gets updated.
	   public boolean onFlushDirty(Object entity,
	                     Serializable id,
	                     Object[] currentState,
	                     Object[] previousState,
	                     String[] propertyNames,
	                     Type[] types) {
	       return true;
	   }
	   public boolean onLoad(Object entity,
	                    Serializable id,
	                    Object[] state,
	                    String[] propertyNames,
	                    Type[] types) {
	       // do nothing
	       return true;
	   }
	   // This method is called when Employee object gets created.
	   public boolean onSave(Object entity,
	                    Serializable id,
	                    Object[] state,
	                    String[] propertyNames,
	                    Type[] types) {
	       if ( entity instanceof Customer ) {
	          System.out.println("Before Save");
	          return true; 
	       }
	       return false;
	   }
	   //called before commit into database
	   public void preFlush(Iterator iterator) {
	   }
	   //called after committed into database
	   public void postFlush(Iterator iterator) {
	   }
}
