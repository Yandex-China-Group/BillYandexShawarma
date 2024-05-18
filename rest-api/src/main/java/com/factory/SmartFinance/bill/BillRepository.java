package com.factory.SmartFinance.bill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "bills", path = "/api/bills")
public interface BillRepository extends JpaRepository<Bill, Long> {
}
