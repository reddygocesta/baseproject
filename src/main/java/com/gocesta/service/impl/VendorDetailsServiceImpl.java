package com.gocesta.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gocesta.dao.VendorDetailsDao;
import com.gocesta.model.VendorApprovalStatus;
import com.gocesta.model.VendorDetails;
import com.gocesta.service.VendorDetailsService;

@Named
public class VendorDetailsServiceImpl implements VendorDetailsService {

	@Inject
	VendorDetailsDao vendorDetailsDao;
	
	@Override
	public List<VendorDetails> getAllVendor() throws Exception {
		return vendorDetailsDao.getAllVendor();
	}

	@Override
	public VendorApprovalStatus getVendorApprovalStatus() throws Exception {
		return vendorDetailsDao.getVendorApprovalStatus();
	}

   

}
