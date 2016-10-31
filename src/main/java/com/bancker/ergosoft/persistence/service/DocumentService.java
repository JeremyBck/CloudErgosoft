package com.bancker.ergosoft.persistence.service;

import com.bancker.ergosoft.persistence.entity.Document;
import com.bancker.ergosoft.persistence.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document addDocument(Document document) {
        return documentRepository.save(document);
    }
}
