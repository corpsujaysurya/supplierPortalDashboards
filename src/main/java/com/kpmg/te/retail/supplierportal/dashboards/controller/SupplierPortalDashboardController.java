package com.kpmg.te.retail.supplierportal.dashboards.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kpmg.te.retail.supplierportal.dashboards.entity.ASN;
import com.kpmg.te.retail.supplierportal.dashboards.entity.Alerts;
import com.kpmg.te.retail.supplierportal.dashboards.entity.CostChange;
import com.kpmg.te.retail.supplierportal.dashboards.entity.Dashboard;
import com.kpmg.te.retail.supplierportal.dashboards.entity.Invoices;
import com.kpmg.te.retail.supplierportal.dashboards.entity.PurchaseOrders;
import com.kpmg.te.retail.supplierportal.dashboards.entity.RetailerReturns;
import com.kpmg.te.retail.supplierportal.dashboards.manager.SupplierPortalDashboardManager;
import com.kpmg.te.retail.supplierportal.dashboards.entity.CustomerReturns;

@Component
public class SupplierPortalDashboardController {
	
	@Autowired
	SupplierPortalDashboardManager dashboardManager;
	
	private static final Logger logger = Logger.getLogger(SupplierPortalDashboardManager.class.getName());
	
				public Dashboard getAllDashboardData() throws ClassNotFoundException, SQLException {
					Dashboard ds = new Dashboard();
					ArrayList<Alerts> alerts = dashboardManager.getLatestAlertsData();
					List<ASN> asn = dashboardManager.getLatestASNData();
					ArrayList<CostChange> cc = dashboardManager.getLatestCostChangeData();
					ArrayList<CustomerReturns> cr = dashboardManager.getLatestsCustomerReturnsData();
					ArrayList<Invoices> inv = dashboardManager.getLatestInvoicesData();
					ArrayList<PurchaseOrders> po = dashboardManager.getLatestPOData();
					List<RetailerReturns> rr = dashboardManager.getLatestRetailerReturnsData();
					ds.setAlertsList(alerts);
					ds.setAsnList(asn);
					ds.setCcList(cc);
					ds.setCrList(cr);
					ds.setInvList(inv);
					ds.setPoList(po);
					ds.setRrList(rr);
					logger.info("The DashboardList is: " + ds.toString());
					return ds;
				}
						
				
}
