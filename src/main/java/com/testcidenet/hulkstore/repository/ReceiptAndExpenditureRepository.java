package com.testcidenet.hulkstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.testcidenet.hulkstore.model.ReceiptAndExpenditure;

public interface ReceiptAndExpenditureRepository  extends MongoRepository<ReceiptAndExpenditure, String>{
	List<ReceiptAndExpenditure> findByFactContainingIgnoreCase(String desc);
	Page<ReceiptAndExpenditure> findByFactContainingIgnoreCase(String find, PageRequest pageRequest);
	Page<ReceiptAndExpenditure> findByDateContainingIgnoreCase(String find, PageRequest pageRequest);
	Page<ReceiptAndExpenditure> findByDescription(String desc, PageRequest of);
	Page<ReceiptAndExpenditure> findByFactLikeOrDateLike(String find, String date, PageRequest pageRequest);
	Optional<ReceiptAndExpenditure> findByFactIgnoreCase(String fact);
	Page<ReceiptAndExpenditure> findByFactContainingIgnoreCaseAndType(String find, boolean type, PageRequest of);
	
}
