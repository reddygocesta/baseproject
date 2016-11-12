package com.gocesta.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gocesta.dao.VendorDetailsDao;
import com.gocesta.mapper.VendorApprovalStatusRowMapper;
import com.gocesta.mapper.VendorDetailsRowMapper;
import com.gocesta.model.VendorApprovalStatus;
import com.gocesta.model.VendorDetails;
import com.gocesta.web.controller.UserController;

@Named
public class VendorDetailsDaoImpl implements VendorDetailsDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<VendorDetails> getAllVendor() {
		
		List<VendorDetails> vendorDetailsList = new ArrayList<VendorDetails>();
		String sql = "call Get_Vendor_Details()";
		try {
			vendorDetailsList = jdbcTemplate.query(sql, new VendorDetailsRowMapper());
		} catch (EmptyResultDataAccessException e) {
			vendorDetailsList = new ArrayList<VendorDetails>();
		} catch (Exception e) {
			LOGGER.error(ExceptionUtils.getStackTrace(e));
			throw e;
		}
		
		return vendorDetailsList;
	}


	@Override
	public VendorApprovalStatus getVendorApprovalStatus() throws Exception {
		
		VendorApprovalStatus approvalStatus = null;
		String sql = "call Get_Vendor_Approval_Status()";
		try {
			approvalStatus = jdbcTemplate.queryForObject(sql, new VendorApprovalStatusRowMapper());
		} catch (EmptyResultDataAccessException e) {
			approvalStatus = null;
		} catch (Exception e) {
			LOGGER.error(ExceptionUtils.getStackTrace(e));
			throw e;
		}
		return approvalStatus;
	}
	
}
