package com.hand.interceptor;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import com.hand.javabean.Customer;

public class CustomerInterceptor extends EmptyInterceptor {

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		 if ( entity instanceof Customer) {
	          System.out.println("Before Save");
	          return true; 
	       }
	       return false;
	}
}
