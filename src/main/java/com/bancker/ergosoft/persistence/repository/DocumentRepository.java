package com.bancker.ergosoft.persistence.repository;

import com.bancker.ergosoft.persistence.entity.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface DocumentRepository extends CrudRepository<Document, Long> {


}
