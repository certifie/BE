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
package ua.andrew.certifie.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.andrew.certifie.model.Certificate;


@Service
public interface CertificateService {

    List<Certificate> getAllCertificates();

    Certificate createCertificate(Certificate certificate);

    Certificate getCertificateById(String certificateId);

    Certificate updateCertificate(String certificateId, Certificate certificateDetails);

    ResponseEntity<?> deleteCertificateById(String certificateId);


}
