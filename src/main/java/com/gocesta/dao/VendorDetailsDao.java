package com.gocesta.dao;

import java.util.List;

import com.gocesta.model.VendorApprovalStatus;
import com.gocesta.model.VendorDetails;

public interface VendorDetailsDao {
	
	public List<VendorDetails> getAllVendor() throws Exception;

	public VendorApprovalStatus getVendorApprovalStatus() throws Exception;
}
