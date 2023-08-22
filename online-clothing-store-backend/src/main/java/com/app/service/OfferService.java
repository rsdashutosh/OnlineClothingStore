package com.app.service;

import java.util.List;

import com.app.dtos.OfferDTO;

public interface OfferService {

	public OfferDTO addOffer(OfferDTO offerDto);

	public OfferDTO updateOffer(OfferDTO offerDto, Integer offerId);

	public String deleteOffer(Integer offerId);

	public OfferDTO getOffer(Integer offerId);

	public List<OfferDTO> getAllOffer();

	public double getDiscountByPromoCode(String promoCode);
	

}
