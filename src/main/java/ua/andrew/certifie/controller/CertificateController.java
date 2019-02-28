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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.andrew.certifie.model.Certificate;
import ua.andrew.certifie.repository.CertificateRepository;


@RestController
@RequestMapping("/api")
public class CertificateController {

    private final String CROSS_ORIGIN = "http://localhost:4200";

    @Autowired
    CertificateRepository certificateRepository;

    @CrossOrigin(origins = CROSS_ORIGIN)
    @GetMapping("/certificates")
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }
}
