package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.app.dtos.OfferDTO;
import com.app.service.OfferService;

@RestController
@RequestMapping("/offers")
@CrossOrigin(origins = "http://localhost:3000")
public class OfferController {

	@Autowired
	private OfferService offerService;

	@PostMapping("/")
	public ResponseEntity<OfferDTO> addOffer(@Valid @RequestBody OfferDTO offerDTO) {
		OfferDTO createdOffer = offerService.addOffer(offerDTO);
		return ResponseEntity.ok(createdOffer);
	}

	@GetMapping("/")
	public ResponseEntity<List<OfferDTO>> getAllOffers() {

		List<OfferDTO> offerDTOs = offerService.getAllOffer();
		return ResponseEntity.ok(offerDTOs);
	}

	@GetMapping("/{offerId}")
	public ResponseEntity<OfferDTO> getOffer(@PathVariable Integer offerId) {
		OfferDTO offerDTO = offerService.getOffer(offerId);
		return ResponseEntity.ok(offerDTO);
	}

	@PutMapping("/offer/{offerId}/add_product/{productId}")
	public ResponseEntity<?> applyOfferToProduct(Integer offerId, Integer productId) {
		return ResponseEntity.status(HttpStatus.OK).body(offerService.applyOfferToProduct(offerId,productId));
	}
	
	@PutMapping("/offer/{offerId}/remove_product/{productId}")
	public ResponseEntity<?> removeOfferFromProduct(Integer offerId, Integer productId) {
		return ResponseEntity.status(HttpStatus.OK).body(offerService.removeOfferFromProduct(offerId,productId));
	}

	@DeleteMapping("/{offerId}")
	public ResponseEntity<String> deleteOffer(@PathVariable Integer offerId) {

		String str = offerService.deleteOffer(offerId);

		return ResponseEntity.ok(str);
	}

//	@GetMapping("/{promoCode}")
//	public ResponseEntity<Double> getDiscountByPromoCode(@PathVariable String promoCode) {
//		double discountAmmount = offerService.getDiscountByPromoCode(promoCode);
//		return ResponseEntity.ok(discountAmmount);
//	}
}
