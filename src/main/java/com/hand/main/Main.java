package com.hand.main;

import java.util.Date;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.hand.dao.AddressDao;
import com.hand.dao.CustomerDao;
import com.hand.javabean.Customer;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		CustomerDao cd = (CustomerDao) context.getBean("customerDao");
		AddressDao ad = (AddressDao) context.getBean("addressDao");
		Customer cus = (Customer) context.getBean("customer");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入FirstName(first_name):");
		String firstName = sc.nextLine();
		System.out.println("请输入LastName(last_name):");
		String lastName = sc.nextLine();
		System.out.println("请输入Email(email):");
		String email = sc.nextLine();
		int addressId;
		System.out.println("请输入Address ID:");
		while(true){
			addressId = sc.nextInt();
			if(ad.isAddress(addressId))break;
			else{
				System.out.println("你输入的Address ID 不存在，请重新输入:");
			}
		}
		System.out.println("Before Save");
		cus.setStoreId(1);
		cus.setFirstName(firstName);
		cus.setLastName(lastName);
		cus.setEmail(email);
		cus.setActive(1);//激活说明该用户存在，默认激活
		cus.setAddressId(addressId);
		cus.setCreateDate(new Date().toLocaleString());
		int cusId;
		if((cusId = cd.addCustomer(cus)) != -1){
			Customer cusTemp = cd.getCustomers(cusId);
			System.out.println("已经保存的数据如下：");
			System.out.println("ID:" + cusTemp.getCustomerId());
			System.out.println("FirstName:" + cusTemp.getFirstName());
			System.out.println("LastName:" + cusTemp.getLastName());
			System.out.println("Email:" + cusTemp.getEmail());
			System.out.println("Address:" + ad.getAddressName(cusTemp.getAddressId()));
		}
		System.out.println("");
		System.out.println("请输入要删除的Customer的ID：");
		while(true){
			cusId = sc.nextInt();
			if(cd.isCustomer(cusId))break;
			else{
				System.out.println("你输入的Customer ID 不存在，请重新输入:");
			}
		}
		if(cd.deleteCustomer(cusId)){
			System.out.println("你输入的ID为" + cusId + "的Customer已经删除.");
		}else{
			System.out.println("删除失败.");
		}
		System.exit(1);
	}

}
