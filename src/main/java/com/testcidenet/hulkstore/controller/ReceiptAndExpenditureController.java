package com.testcidenet.hulkstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testcidenet.hulkstore.model.ReceiptAndExpenditure;
import com.testcidenet.hulkstore.repository.ReceiptAndExpenditureRepository;

import net.minidev.json.JSONObject;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ReceiptAndExpenditureController {

	@Autowired
	ReceiptAndExpenditureRepository receiptAndExpenditureRepository;

	@GetMapping("/receiptandexpenditures")
	public ResponseEntity<List<ReceiptAndExpenditure>> getAllReceipts(@RequestParam(required = false) String fact) {
		try {
			List<ReceiptAndExpenditure> receiptsAndExpenditures = new ArrayList<ReceiptAndExpenditure>();

			if (fact == null)
				receiptAndExpenditureRepository.findAll().forEach(receiptsAndExpenditures::add);
			else
				receiptAndExpenditureRepository.findByFactContainingIgnoreCase(fact).forEach(receiptsAndExpenditures::add);

			if (receiptsAndExpenditures.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(receiptsAndExpenditures, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/receiptandexpendituresFind")
	public ResponseEntity<JSONObject> getAllReceiptsAndExpendituresPageable(@RequestParam(required = false) String find,@RequestParam(required = false) boolean type,
			@RequestParam(required = true) int page, @RequestParam(required = true) int itemPage,
			@RequestParam(required = true) String order) {
		try {
			Page<ReceiptAndExpenditure> pages = null;
			List<ReceiptAndExpenditure> receiptsAndExpenditures = new ArrayList<ReceiptAndExpenditure>();
			JSONObject entity = new JSONObject();
			Direction dir = (order.equals("asc")) ? Direction.ASC : Direction.DESC;

			if (find == null)
				pages = receiptAndExpenditureRepository.findAll(PageRequest.of(page, itemPage));
			else
				pages = receiptAndExpenditureRepository.findByFactContainingIgnoreCaseAndType(find, type, PageRequest.of(page, itemPage, dir, "Date"));

			receiptsAndExpenditures = pages.getContent();

			entity.put("pages", pages.getTotalPages());
			entity.put("total_elements", pages.getTotalElements());
			entity.put("receiptsAndExpenditures", receiptsAndExpenditures);
			
			System.out.print(entity);

			return new ResponseEntity<JSONObject>(entity, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/receiptandexpenditures")
	public ResponseEntity<ReceiptAndExpenditure> createReceiptAndExpenditure(
			@RequestBody ReceiptAndExpenditure receiptAndExpenditure) {

		try {
			Optional<ReceiptAndExpenditure> receiptAndExpenditureData = receiptAndExpenditureRepository
					.findByFactIgnoreCase(receiptAndExpenditure.getFact());
			if (!receiptAndExpenditureData.isPresent()) {
				ReceiptAndExpenditure _receiptAndExpenditure = receiptAndExpenditureRepository
						.save(new ReceiptAndExpenditure(receiptAndExpenditure.getFact(),
								receiptAndExpenditure.getType(), receiptAndExpenditure.getDescription(),
								receiptAndExpenditure.getDate(), receiptAndExpenditure.getProducts()));
				return new ResponseEntity<>(_receiptAndExpenditure, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(HttpStatus.LOCKED);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

}
