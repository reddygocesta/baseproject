package com.gocesta.service;

import java.util.List;

import com.gocesta.model.VendorApprovalStatus;
import com.gocesta.model.VendorDetails;

public interface VendorDetailsService {
	
	public List<VendorDetails> getAllVendor() throws Exception;

	public VendorApprovalStatus getVendorApprovalStatus() throws Exception;
}
