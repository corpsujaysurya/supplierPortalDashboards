package com.kpmg.te.retail.supplierportal.dashboards.service;

import java.sql.SQLException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kpmg.te.retail.supplierportal.dashboards.controller.SupplierPortalDashboardController;
import com.kpmg.te.retail.supplierportal.dashboards.dao.SupplierPortalDashboardDao;
import com.kpmg.te.retail.supplierportal.dashboards.manager.SupplierPortalDashboardManager;
import com.kpmg.te.retail.supplierportal.dashboards.entity.Dashboard;

@RestController
@RequestMapping("/api/dashboard/service")
public class SupplierPortalDashboardService {
	
	@Autowired
	SupplierPortalDashboardManager dashboardManager;

	@Autowired
	SupplierPortalDashboardDao dashboardDao;
	
	@Autowired
	SupplierPortalDashboardController dashboardController;

	private static final Logger logger = Logger.getLogger(SupplierPortalDashboardService.class.getName());

	@RequestMapping(path = "/getAllDashboardData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Dashboard getDashboardData() throws ClassNotFoundException, SQLException {
		Dashboard dbrd = new Dashboard();
		dbrd = dashboardController.getAllDashboardData();
		logger.info(dbrd.toString());
		return  dbrd;
	}

	}


