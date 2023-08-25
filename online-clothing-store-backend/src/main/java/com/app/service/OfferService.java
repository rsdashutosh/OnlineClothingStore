package com.app.service;

import java.util.List;

import com.app.dtos.OfferDTO;

public interface OfferService {

	public OfferDTO addOffer(OfferDTO offerDto);
	
	public OfferDTO getOffer(Integer offerId);
	public List<OfferDTO> getAllOffer();
	public double getDiscountByPromoCode(String promoCode);
	
	public String applyOfferToProduct(Integer offerId, Integer productId);
	public String removeOfferFromProduct(Integer offerId, Integer productId);

	public String deleteOffer(Integer offerId);
	

	

}
