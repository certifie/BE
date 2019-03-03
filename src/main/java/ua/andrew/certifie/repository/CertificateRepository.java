package ua.andrew.certifie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.andrew.certifie.model.Certificate;


@Repository
public interface CertificateRepository extends JpaRepository<Certificate, String> {
}
