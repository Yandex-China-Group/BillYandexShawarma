package com.factory.SmartFinance.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "payment_categories", path = "/api/payment_categories")
public interface PaymentCategoryRepository extends JpaRepository<PaymentCategory, String> {
}
