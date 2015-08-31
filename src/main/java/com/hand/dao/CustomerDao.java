package com.hand.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hand.interceptor.CustomerInterceptor;
import com.hand.javabean.Customer;

public class CustomerDao {
	private SessionFactory factory;
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	//添加客户
	public Integer addCustomer(Customer customer){
		Session session = factory.withOptions().interceptor(new CustomerInterceptor()).openSession();
		Transaction tx = null;
		Integer cusID = -1;
		try{
			tx = session.beginTransaction();
			cusID = (Integer) session.save(customer);
			tx.commit();
		}catch(HibernateException e){
			if(tx != null)tx.rollback();
			e.printStackTrace();
			return cusID;
		}finally {
			session.close();
		}
		return cusID;
	}
	
	//根据地址ID查询客户是否存在
	public boolean isCustomer(int cusId){
		Session session = factory.openSession();
		Transaction tx = null;
		Customer customer = null;
		try{
			tx = session.beginTransaction();
			customer = session.get(Customer.class, cusId);
			tx.commit();
		}catch(HibernateException e){
			if(tx != null)tx.rollback();
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
			if(tx != null)tx.rollback();
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}
		return true;
	}
	
	//根据客户ID查询客户信息
	public Customer getCustomers(int cusId){
		Session session = factory.openSession();
		Transaction tx = null;
		Customer cus = null;
		try{
			tx = session.beginTransaction();
			cus = session.get(Customer.class, cusId);
			tx.commit();
		}catch(HibernateException e){
			if(tx != null)tx.rollback();
			e.printStackTrace();
			return cus;
		}finally {
			session.close();
		}
		return cus;
	}
}
