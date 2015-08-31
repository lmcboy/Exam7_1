package com.hand.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hand.interceptor.CustomerInterceptor;
import com.hand.javabean.Customer;

public class CustomerDao {
	private SessionFactory factory;
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	//添加客户
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Integer addCustomer(Customer customer){
		Session session = factory.withOptions().interceptor(new CustomerInterceptor()).openSession();
		Integer cusID = -1;
		try{
			cusID = (Integer) session.save(customer);
		}catch(HibernateException e){
			e.printStackTrace();
			return cusID;
		}finally {
			session.close();
		}
		return cusID;
	}
	
	//根据地址ID查询客户是否存在
	@Transactional(readOnly=true)
	public boolean isCustomer(int cusId){
		Session session = factory.openSession();
		Customer customer = null;
		try{
			customer = session.get(Customer.class, cusId);
		}catch(HibernateException e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		if(customer == null)return false;
		else{
			if(customer.getActive() == 0)return false;
			else return true;
		}
	}
	
	//根据客户ID删除
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public boolean deleteCustomer(int cusId){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Customer customer = session.get(Customer.class, cusId);
			customer.setActive(0);
			session.update(customer);
			tx.commit();
		}catch(HibernateException e){
			if(session != null)tx.rollback();
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}
		return true;
	}
	
	//根据客户ID查询客户信息
	@Transactional(readOnly=true)
	public Customer getCustomers(int cusId){
		Session session = factory.openSession();
		Customer cus = null;
		try{
			cus = session.get(Customer.class, cusId);
		}catch(HibernateException e){
			e.printStackTrace();
			return cus;
		}finally {
			session.close();
		}
		return cus;
	}
}
