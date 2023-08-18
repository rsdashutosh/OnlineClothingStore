package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.OfferDto;
import com.app.service.OfferService;

@RestController
@RequestMapping("/offers")
public class OfferController {

	@Autowired
	private OfferService offerService;

	@PostMapping("/")
	public ResponseEntity<OfferDto> addOffer(@RequestBody OfferDto offerDto) {
		OfferDto craetedOffer = offerService.addOffer(offerDto);
		return ResponseEntity.ok(craetedOffer);

	}

	@GetMapping("/")
	public ResponseEntity<List<OfferDto>> getAllOffers() {

		List<OfferDto> offerDtos = offerService.getAllOffer();
		return ResponseEntity.ok(offerDtos);
	}

	@GetMapping("/{offerId}")
	public ResponseEntity<OfferDto> getOffer(@PathVariable Integer offerId) {
		OfferDto offerDto = offerService.getOffer(offerId);
		return ResponseEntity.ok(offerDto);
	}

	@PutMapping("/{offerId}")
	public ResponseEntity<OfferDto> updateOffer(@RequestBody OfferDto offerDto, @PathVariable Integer offerId) {
		OfferDto updatedOfferDto = offerService.updateOffer(offerDto, offerId);
		return ResponseEntity.ok(updatedOfferDto);
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
