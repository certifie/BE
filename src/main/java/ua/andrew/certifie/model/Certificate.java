/*
 * ====================================================================
 *
 * Follett Software Company
 *
 * Copyright (c) 2019 Follett Software Company
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, is not permitted without a written agreement
 * from Follett Software Company.
 *
 * ====================================================================
 */
package ua.andrew.certifie.model;


import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "certificates")
@EntityListeners(AuditingEntityListener.class)
public class Certificate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private Calendar issueDate;

    @NotBlank
    private Calendar expiryDate;

    @NotBlank
    private String issuer;

    @NotBlank
    private String serialNumber;

    @NotBlank
    private Boolean isExpiry;

    @NotBlank
    private String description;

    @NotBlank
    private String courseUrl;

    //    TODO write class which will handle certificate attachment
    //    private Attachment attachment;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Calendar getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(Calendar issueDate) {
        this.issueDate = issueDate;
    }
    public Calendar getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }
    public String getIssuer() {
        return issuer;
    }
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public Boolean getExpiry() {
        return isExpiry;
    }
    public void setExpiry(Boolean isExpiry) {
        this.isExpiry = isExpiry;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCourseUrl() {
        return courseUrl;
    }
    public void setCourseUrl(String courseUrl) {
        this.courseUrl = courseUrl;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
