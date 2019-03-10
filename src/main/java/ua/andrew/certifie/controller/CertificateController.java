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
import ua.andrew.certifie.service.CertificateService;


@RestController
@RequestMapping("/api/certificates")
@CrossOrigin("http://localhost:4200")
public class CertificateController {

    @Autowired
    CertificateService certificateService;

    @GetMapping
    public List<Certificate> getAllCertificates() {
        return certificateService.getAllCertificates();
    }

    @PostMapping
    public Certificate createCertificate(@RequestBody Certificate certificate) {
        return certificateService.createCertificate(certificate);
    }

    @GetMapping("/{id}")
    public Certificate getCertificateById(@PathVariable(value = "id") String certificateId) {
        return certificateService.getCertificateById(certificateId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCertificateById(@PathVariable(value = "id") String certificateId) {
        certificateService.deleteCertificateById(certificateId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public Certificate updateCertificate(@PathVariable(value = "id") String certificateId,
                                         @Valid @RequestBody Certificate certificateDetails) {
        return certificateService.updateCertificate(certificateId, certificateDetails);
    }
}
