package com.kpmg.te.retail.supplierportal.dashboards.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.dashboards.constants.DashboardConstants;
import com.kpmg.te.retail.supplierportal.dashboards.entity.ASN;
import com.kpmg.te.retail.supplierportal.dashboards.entity.Alerts;
import com.kpmg.te.retail.supplierportal.dashboards.entity.CostChange;
import com.kpmg.te.retail.supplierportal.dashboards.entity.CustomerReturns;
import com.kpmg.te.retail.supplierportal.dashboards.entity.Invoices;
import com.kpmg.te.retail.supplierportal.dashboards.entity.PurchaseOrders;
import com.kpmg.te.retail.supplierportal.dashboards.entity.RetailerReturns;


@Component
public class SupplierPortalDashboardDao {
	
	private static final Logger logger = Logger.getLogger(SupplierPortalDashboardDao.class.getName());
	
	public Connection getConnectioDetails() throws ClassNotFoundException, SQLException {
		String myDriver = DashboardConstants.myDriver;
		String myUrl = DashboardConstants.myUrl;
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, DashboardConstants.mySQL_ID, DashboardConstants.mySQL_pass);
		return conn;
	}

	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}

	public ArrayList<Alerts> getLatestAlertsData() throws ClassNotFoundException, SQLException {
		Alerts alerts;
		ArrayList<Alerts> alertsList = new ArrayList<Alerts>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  MODULE, MESSAGE, CREATIONDATETIME from SUPPLIER_PORTAL.ALERTS_DASHBOARD ORDER BY CREATIONDATETIME DESC LIMIT 8";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			alerts = new Alerts();
			alerts.setModule(rs.getString("module"));
			alerts.setMessage(rs.getString("message"));
			alerts.setCreationDateTime(rs.getString("creationdatetime"));
			alertsList.add(alerts);
		}

		logger.info("The Alerts list is: " + alertsList.toString());
		return alertsList;
	}

	public List<ASN> getLatestASNData() throws SQLException, ClassNotFoundException {
		ASN asn;
		ArrayList<ASN> asnList = new ArrayList<ASN>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  ASNNUMBER, STATUS, CREATIONDATETIME from SUPPLIER_PORTAL.ASN_DASHBOARD ORDER BY CREATIONDATETIME DESC LIMIT 8";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			asn = new ASN();
			asn.setAsnNumber(rs.getString("asnnumber"));
			asn.setStatus(rs.getString("status"));
			asn.setCreationDateTime(rs.getString("creationdatetime"));
			asnList.add(asn);
		}

		logger.info("The ASN list is: " + asnList.toString());
		return asnList;
	}

	public List<RetailerReturns> getLatesRRData() throws SQLException, ClassNotFoundException {
		RetailerReturns rr;
		ArrayList<RetailerReturns> rrList = new ArrayList<RetailerReturns>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  RETURNID, STATUS, CREATIONDATETIME from SUPPLIER_PORTAL.RR_DASHBOARD ORDER BY CREATIONDATETIME DESC LIMIT 2";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			rr = new RetailerReturns();
			rr.setReturnId(rs.getString("returnId"));
			rr.setStatus(rs.getString("status"));
			rr.setCreationDateTime(rs.getString("creationdatetime"));
			rrList.add(rr);
		}

		logger.info("The Retailer Returns list is: " + rrList.toString());
		return rrList;
	}

	public ArrayList<PurchaseOrders> getLatestPOData() throws SQLException, ClassNotFoundException {
		PurchaseOrders po;
		ArrayList<PurchaseOrders> poList = new ArrayList<PurchaseOrders>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  PONUMBER, STATUS, CREATIONDATETIME from SUPPLIER_PORTAL.PO_DASHBOARD ORDER BY CREATIONDATETIME DESC LIMIT 4";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			po = new PurchaseOrders();
			po.setPoNumber(rs.getString("ponumber"));
			po.setStatus(rs.getString("status"));
			po.setCreationDateTime(rs.getString("creationdatetime"));
			poList.add(po);
		}
		logger.info("The Purchase Order list is: " + poList.toString());
		return poList;
	}

	public ArrayList<Invoices> getLatestInvData() throws SQLException, ClassNotFoundException {
		Invoices inv;
		ArrayList<Invoices> invList = new ArrayList<Invoices>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  INVOICENO, STATUS, CREATIONDATETIME from SUPPLIER_PORTAL.INVOICE_DASHBOARD ORDER BY CREATIONDATETIME DESC LIMIT 3";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			inv = new Invoices();
			inv.setInvoiceNo(rs.getString("invoiceNo"));
			inv.setStatus(rs.getString("status"));
			inv.setCreationDateTime(rs.getString("creationdatetime"));
			invList.add(inv);
		}

		logger.info("The Invoices list is: " + invList.toString());
		return invList;
	}

	public ArrayList<CostChange> getLatestCCData() throws SQLException, ClassNotFoundException {
		CostChange cc;
		ArrayList<CostChange> ccList = new ArrayList<CostChange>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  ITEMID, STATUS, CREATIONDATETIME from SUPPLIER_PORTAL.CC_DASHBOARD ORDER BY CREATIONDATETIME DESC LIMIT 2";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			cc = new CostChange();
			cc.setItemId(rs.getString("itemid"));
			cc.setStatus(rs.getString("status"));
			cc.setCreationDateTime(rs.getString("creationdatetime"));
			ccList.add(cc);
		}

		logger.info("The Cost change list is: " + ccList.toString());
		return ccList;
	}

	public ArrayList<CustomerReturns> getLatestCRData() throws SQLException, ClassNotFoundException {
		CustomerReturns cr;
		ArrayList<CustomerReturns> crList = new ArrayList<CustomerReturns>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  RETURNID, STATUS, CREATIONDATETIME from SUPPLIER_PORTAL.CR_DASHBOARD ORDER BY CREATIONDATETIME DESC LIMIT 8 ";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			cr = new CustomerReturns();
			cr.setReturnId(rs.getString("returnId"));
			cr.setStatus(rs.getString("status"));
			cr.setCreationDateTime(rs.getString("creationdatetime"));
			crList.add(cr);
		}

		logger.info("The Customer Returns list is: " + crList.toString());
		return crList;
	}

}
