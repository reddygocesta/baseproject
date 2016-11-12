package com.gocesta.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gocesta.model.VendorApprovalStatus;

public class VendorApprovalStatusRowMapper implements RowMapper<VendorApprovalStatus> {

	public VendorApprovalStatus mapRow(ResultSet rs, int rowNo) throws SQLException {

		VendorApprovalStatus vendorApprovalStatus = new VendorApprovalStatus();
		vendorApprovalStatus.setApprovedCount(rs.getInt("appoved_count"));
		vendorApprovalStatus.setPendingCount(rs.getInt("pending_count"));
		vendorApprovalStatus.setDeclainedCount(rs.getInt("declained_count"));
		return vendorApprovalStatus;

	}

}
