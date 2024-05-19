package com.factory.SmartFinance.entities.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "transaction_types", path = "transaction_type")
public interface TransactionTypeRepository extends JpaRepository<TransactionType, String> {
}
