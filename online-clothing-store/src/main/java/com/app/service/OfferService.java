package com.app.service;

import java.util.List;

import com.app.dtos.OfferDto;

public interface OfferService {

	public OfferDto addOffer(OfferDto offerDto);

	public OfferDto updateOffer(OfferDto offerDto, Integer offerId);

	public String deleteOffer(Integer offerId);

	public OfferDto getOffer(Integer offerId);

	public List<OfferDto> getAllOffer();

	public double getDiscountByPromoCode(String promoCode);
	

}
