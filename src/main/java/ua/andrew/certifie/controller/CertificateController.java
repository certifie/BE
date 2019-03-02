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
package ua.andrew.certifie.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.andrew.certifie.exception.ResourceNotFoundException;
import ua.andrew.certifie.model.Certificate;
import ua.andrew.certifie.repository.CertificateRepository;


@RestController
@RequestMapping("/api/certificates")
@CrossOrigin("http://localhost:4200")
public class CertificateController {

    @Autowired
    CertificateRepository certificateRepository;

    @GetMapping
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    @PostMapping
    public Certificate createCertificate(@RequestBody Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    @GetMapping("/{id}")
    public Certificate getCertificateById(@PathVariable(value = "id") Long certificateId) {
        return certificateRepository.findById(certificateId)
                .orElseThrow(() -> new ResourceNotFoundException("Certificate", "id", certificateId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCertificateById(@PathVariable(value = "id") Long certificateId) {
        Certificate certificate = certificateRepository.findById(certificateId)
                .orElseThrow(() -> new ResourceNotFoundException("Certificate", "id", certificateId));

        certificateRepository.delete(certificate);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public Certificate updateCertificate(@PathVariable(value = "id") Long certificateId,
                                         @Valid @RequestBody Certificate certificateDetails) {
        Certificate certificate = certificateRepository.findById(certificateId)
                .orElseThrow(() -> new ResourceNotFoundException("Certificate", "id", certificateId));

        certificate.setTitle(certificateDetails.getTitle());
        certificate.setCourseUrl(certificateDetails.getCourseUrl());
        certificate.setIssuer(certificateDetails.getIssuer());
        certificate.setDescription(certificateDetails.getDescription());
        certificate.setExpiry(certificateDetails.getExpiry());
        certificate.setSerialNumber(certificateDetails.getSerialNumber());
        certificate.setIssueDate(certificateDetails.getIssueDate());
        certificate.setExpiryDate(certificateDetails.getExpiryDate());

        return certificateRepository.save(certificate);
    }
}
