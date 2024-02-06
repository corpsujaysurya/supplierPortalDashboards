package com.kpmg.te.retail.supplierportal.dashboards.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.dashboards.dao.SupplierPortalDashboardDao;
import com.kpmg.te.retail.supplierportal.dashboards.entity.ASN;
import com.kpmg.te.retail.supplierportal.dashboards.entity.Alerts;
import com.kpmg.te.retail.supplierportal.dashboards.entity.CostChange;
import com.kpmg.te.retail.supplierportal.dashboards.entity.CustomerReturns;
import com.kpmg.te.retail.supplierportal.dashboards.entity.Invoices;
import com.kpmg.te.retail.supplierportal.dashboards.entity.PurchaseOrders;
import com.kpmg.te.retail.supplierportal.dashboards.entity.RetailerReturns;

@Component
public class SupplierPortalDashboardManager {

	@Autowired
	private SupplierPortalDashboardDao dashboardDao;

	private static final Logger logger = Logger.getLogger(SupplierPortalDashboardManager.class.getName());

	public ArrayList<Alerts> getLatestAlertsData() throws ClassNotFoundException, SQLException {
		return dashboardDao.getLatestAlertsData();
	}

	public List<ASN> getLatestASNData() throws ClassNotFoundException, SQLException {
		return dashboardDao.getLatestASNData();
	}

	public List<RetailerReturns> getLatestRetailerReturnsData() throws ClassNotFoundException, SQLException {
		return dashboardDao.getLatesRRData();
	}

	public ArrayList<PurchaseOrders> getLatestPOData() throws ClassNotFoundException, SQLException {
		return dashboardDao.getLatestPOData();
	}

	public ArrayList<Invoices> getLatestInvoicesData() throws ClassNotFoundException, SQLException {
		return dashboardDao.getLatestInvData();
	}

	public ArrayList<CostChange> getLatestCostChangeData() throws ClassNotFoundException, SQLException {
		return dashboardDao.getLatestCCData();
	}

	public ArrayList<CustomerReturns> getLatestsCustomerReturnsData() throws ClassNotFoundException, SQLException {
		return dashboardDao.getLatestCRData();
	}

}
