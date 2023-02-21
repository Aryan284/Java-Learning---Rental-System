package main.model;

import java.time.LocalDateTime;

public class LicenseInfo {
    private String licenseNumber;
    private LocalDateTime issueDate;
    private LocalDateTime expiryDate;
    private String issuedCountry;
    private LicenseType licenseType;


    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getIssuedCountry() {
        return issuedCountry;
    }

    public void setIssuedCountry(String issuedCountry) {
        this.issuedCountry = issuedCountry;
    }

    public LicenseType getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(LicenseType licenseType) {
        this.licenseType = licenseType;
    }
}
