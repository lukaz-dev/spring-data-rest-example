package com.guitar.db.repository;

import com.guitar.db.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Date;
import java.util.List;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RepositoryRestResource(path = "companies", collectionResourceRel = "companies")
public interface ManufacturerJpaRepository extends JpaRepository<Manufacturer, Long> {

    List<Manufacturer> findByFoundedDateBefore(Date date);

    List<Manufacturer> findByActiveTrue();

    List<Manufacturer> findByActiveFalse();

    List<Manufacturer> getAllThatSellAcoustics(String name);
}
