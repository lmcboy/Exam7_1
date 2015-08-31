package com.hand.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.hand.javabean.Address;
@Transactional  
public class AddressDao {
	private SessionFactory factory;
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	//根据地址ID查询地址是否存在
	@Transactional(readOnly=true)
	public boolean isAddress(int addressId){
		Session session = factory.openSession();
		Address address = null;
		try{
			address = session.get(Address.class, addressId);
		}catch(HibernateException e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		if(address == null)return false;
		else return true;
	}
	
	//根据地址ID查询地址名称
	@Transactional(readOnly=true)
	public String getAddressName(int addressId){
		Session session = factory.openSession();
		String addressName = null;
		try{
			Address addr = session.get(Address.class, addressId);
			addressName = addr.getAddress();
		}catch(HibernateException e){
			e.printStackTrace();
			return addressName;
		}finally {
			session.close();
		}
		return addressName;
	}
}
