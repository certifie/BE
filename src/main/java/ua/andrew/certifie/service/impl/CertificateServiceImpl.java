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
package ua.andrew.certifie.service.impl;


import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.andrew.certifie.exception.ResourceNotFoundException;
import ua.andrew.certifie.model.Certificate;
import ua.andrew.certifie.repository.CertificateRepository;
import ua.andrew.certifie.service.CertificateService;

@Service
@Transactional
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateRepository repository;

    @Override public List<Certificate> getAllCertificates() {
        return repository.findAll();
    }
    @Override public Certificate createCertificate(Certificate certificate) {
        return repository.save(certificate);
    }

    @Override public Certificate getCertificateById(String certificateId) {
        return repository.findById(certificateId)
                .orElseThrow(() -> new ResourceNotFoundException("Certificate", "id", certificateId));
    }
    @Override public Certificate updateCertificate(String certificateId, Certificate certificateDetails) {
        Certificate certificate = repository.findById(certificateId)
                .orElseThrow(() -> new ResourceNotFoundException("Certificate", "id", certificateId));

        certificate.setTitle(certificateDetails.getTitle());
        certificate.setExpiryDate(certificateDetails.getExpiryDate());
        certificate.setExpiry(certificateDetails.getExpiry());
        certificate.setSerialNumber(certificateDetails.getSerialNumber());
        certificate.setDescription(certificateDetails.getDescription());
        certificate.setIssuer(certificateDetails.getIssuer());
        certificate.setCourseUrl(certificateDetails.getCourseUrl());
        certificate.setIssueDate(certificateDetails.getIssueDate());

        return repository.save(certificate);
    }

    @Override public ResponseEntity<?> deleteCertificateById(String certificateId) {
        Certificate certificate = repository.findById(certificateId)
                .orElseThrow(() -> new ResourceNotFoundException("Certificate", "id", certificateId));

        repository.delete(certificate);

        return ResponseEntity.ok().build();
    }
}
