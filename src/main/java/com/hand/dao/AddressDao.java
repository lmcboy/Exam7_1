package com.hand.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hand.javabean.Address;

public class AddressDao {
	private SessionFactory factory;
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	//根据地址ID查询地址是否存在
	public boolean isAddress(int addressId){
		Session session = factory.openSession();
		Transaction tx = null;
		Address address = null;
		try{
			tx = session.beginTransaction();
			address = session.get(Address.class, addressId);
			tx.commit();
		}catch(HibernateException e){
			if(tx != null)tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		if(address == null)return false;
		else return true;
	}
	
	//根据地址ID查询地址名称
	public String getAddressName(int addressId){
		Session session = factory.openSession();
		Transaction tx = null;
		String addressName = null;
		try{
			tx = session.beginTransaction();
			Address addr = session.get(Address.class, addressId);
			addressName = addr.getAddress();
			tx.commit();
		}catch(HibernateException e){
			if(tx != null)tx.rollback();
			e.printStackTrace();
			return addressName;
		}finally {
			session.close();
		}
		return addressName;
	}
}
