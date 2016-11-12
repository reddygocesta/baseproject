package com.gocesta.model;

public class VendorApprovalStatus {
	
	private int approvedCount;
	private int pendingCount;
	private int declainedCount;
	
	public int getApprovedCount() {
		return approvedCount;
	}
	public void setApprovedCount(int approvedCount) {
		this.approvedCount = approvedCount;
	}
	public int getPendingCount() {
		return pendingCount;
	}
	public void setPendingCount(int pendingCount) {
		this.pendingCount = pendingCount;
	}
	public int getDeclainedCount() {
		return declainedCount;
	}
	public void setDeclainedCount(int declainedCount) {
		this.declainedCount = declainedCount;
	}
	
}
