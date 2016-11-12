package com.gocesta.web.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gocesta.model.VendorApprovalStatus;
import com.gocesta.model.VendorDetails;
import com.gocesta.service.VendorDetailsService;

@RestController
public class VendorDetailsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VendorDetailsController.class);

    @Inject
    private VendorDetailsService vendorDetailsService;

    @RequestMapping(value = "/vendorlist", method = RequestMethod.GET)
    public List<VendorDetails> vendorList() {
    	LOGGER.info("get all vendor list");
    	List<VendorDetails> vendorDetailsList = null;
        try {
        	vendorDetailsList = vendorDetailsService.getAllVendor();
		} catch (Exception e) {
			LOGGER.error(ExceptionUtils.getStackTrace(e));
		}
        return vendorDetailsList;
    }

    @RequestMapping(value = "/vendorapprovalstatus", method = RequestMethod.GET)
    public VendorApprovalStatus vendorApprovalStatus() {
        LOGGER.info("get vendor approval status");
        VendorApprovalStatus approvalStatus = null;
        try {
        	approvalStatus = vendorDetailsService.getVendorApprovalStatus();
		} catch (Exception e) {
			LOGGER.error(ExceptionUtils.getStackTrace(e));
		}
        
        return approvalStatus;
    }

}

 
