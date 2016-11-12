package com.gocesta.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gocesta.model.Address;
import com.gocesta.model.CompanyDetails;
import com.gocesta.model.Country;
import com.gocesta.model.State;
import com.gocesta.model.VendorDetails;

public class VendorDetailsRowMapper implements RowMapper<VendorDetails> {

	public VendorDetails mapRow(ResultSet rs, int rowNo) throws SQLException {

		VendorDetails vendorDetails = new VendorDetails();
		vendorDetails.setVendorId(rs.getLong("vendor_id"));
		vendorDetails.setFirstName(rs.getString("first_name"));
		vendorDetails.setLastName(rs.getString("last_name"));
		vendorDetails.setEmailId(rs.getString("email_id"));
		vendorDetails.setMobileNumber(rs.getString("mobile_number"));
		vendorDetails.setRentalLicense(rs.getString("rental_license"));
		
		CompanyDetails companyDetails = new CompanyDetails();
		companyDetails.setCompanyId(rs.getInt(""));;
		companyDetails.setCompanyName(rs.getString("company_name"));
		companyDetails.setRegistrationCertificate(rs.getString("registration_certificate"));
		
		Address address = new Address();
		address.setAddressId(rs.getLong("address_id"));
		address.setAddressLine1(rs.getString("address_line1"));
		address.setAddressLine2(rs.getString("address_line2"));
		address.setCity(rs.getString("city"));
		
		State state = new State();
		state.setState(rs.getString("state"));
		address.setState(state);
		
		Country country = new Country();
		country.setCountry(rs.getString("country"));
		address.setCountry(country);
		
		companyDetails.setAddress(address);
		
		vendorDetails.setCompanyDetails(companyDetails);
		
		return vendorDetails;

	}

}