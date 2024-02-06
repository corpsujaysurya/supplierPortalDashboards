package com.kpmg.te.retail.supplierportal.dashboards.entity;

import java.util.ArrayList;
import java.util.List;

public class Dashboard {

	private ArrayList<Alerts> alertsList;
	private List<ASN>  asnList;
	private ArrayList<CostChange>  ccList;
	private ArrayList<CustomerReturns>  crList;
	private ArrayList<Invoices>  invList;
	private ArrayList<PurchaseOrders>  poList;
	private List<RetailerReturns>  rrList;
	
	public ArrayList<Alerts> getAlertsList() {
		return alertsList;
	}
	public void setAlertsList(ArrayList<Alerts> alertsList) {
		this.alertsList = alertsList;
	}
	public List<ASN> getAsnList() {
		return asnList;
	}
	public void setAsnList(List<ASN> asn) {
		this.asnList = asn;
	}
	public ArrayList<CostChange> getCcList() {
		return ccList;
	}
	public void setCcList(ArrayList<CostChange> ccList) {
		this.ccList = ccList;
	}
	public ArrayList<CustomerReturns> getCrList() {
		return crList;
	}
	public void setCrList(ArrayList<CustomerReturns> crList) {
		this.crList = crList;
	}
	public ArrayList<Invoices> getInvList() {
		return invList;
	}
	public void setInvList(ArrayList<Invoices> invList) {
		this.invList = invList;
	}
	public ArrayList<PurchaseOrders> getPoList() {
		return poList;
	}
	public void setPoList(ArrayList<PurchaseOrders> poList) {
		this.poList = poList;
	}
	public List<RetailerReturns> getRrList() {
		return rrList;
	}
	public void setRrList(List<RetailerReturns> rr) {
		this.rrList = rr;
	}
	@Override
	public String toString() {
		return "Dashboard [alertsList=" + alertsList + ", asnList=" + asnList + ", ccList=" + ccList + ", crList="
				+ crList + ", invList=" + invList + ", poList=" + poList + ", rrList=" + rrList + "]";
	}
	
	

}
