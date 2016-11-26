package com.caramel.restaurant.model.view.message;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class BasicDataBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1616751649739679266L;
	
	private int tablesFor2;
	private int tablesFor6;
	
	private String logoUrl;
	private String phone;
	private String address;
	private String email;
	private String restaurationName;
	private String footerInfo;
	
	
	//getters and setters
	public int getTablesFor2() {
		return tablesFor2;
	}
	public void setTablesFor2(int tablesFor2) {
		this.tablesFor2 = tablesFor2;
	}
	public int getTablesFor6() {
		return tablesFor6;
	}
	public void setTablesFor6(int tablesFor6) {
		this.tablesFor6 = tablesFor6;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRestaurationName() {
		return restaurationName;
	}
	public void setRestaurationName(String restaurationName) {
		this.restaurationName = restaurationName;
	}
	public String getFooterInfo() {
		return footerInfo;
	}
	public void setFooterInfo(String footerInfo) {
		this.footerInfo = footerInfo;
	}
	
}
