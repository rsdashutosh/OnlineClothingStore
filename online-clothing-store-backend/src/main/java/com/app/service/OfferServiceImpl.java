package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.OfferDTO;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.Offer;
import com.app.pojos.Product;
import com.app.repository.OfferRepository;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private OfferRepository offerRepo;
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public OfferDTO addOffer(OfferDTO offerDTO) {

		Offer offer = mapper.map(offerDTO, Offer.class);
		Offer persistantOffer = offerRepo.save(offer);
		
		return mapper.map(persistantOffer, OfferDTO.class);

	}
	
	@Override
	public OfferDTO getOffer(Integer offerId) {
		Offer offer = offerRepo.findById(offerId)
				.orElseThrow(() -> new ResourceNotFoundException("Offer", "Id", offerId));
		OfferDTO offerDTO = mapper.map(offer, OfferDTO.class);
		return offerDTO;
	}

	@Override
	public List<OfferDTO> getAllOffer() {
		List<Offer> offers = offerRepo.findAll();
		List<OfferDTO> offerDTOs = offers.stream().map(offer -> mapper.map(offer, OfferDTO.class))
				.collect(Collectors.toList());
		return offerDTOs;
	}

	@Override
	public double getDiscountByPromoCode(String promoCode) {
		List<Offer> offers = offerRepo.findAll();
		for (Offer offer : offers) {

			if (offer.getPromoCode().equals(promoCode))

				return offer.getDiscountAmount();

		}
		return 0;
	}
	
	// when we want to apply an offer to a product
	@Override
	public String applyOfferToProduct(Integer offerId, Integer productId) {
		// Fetch the offer by the offer id
		Offer offer=offerRepo.findById(offerId).get();
		// fetch the product by product id
		Product product=productRepo.findById(productId).get();
		
		// adding entry on both the sides 
		offer.addProduct(product);
		product.addOffer(offer);
		return "offer with offerId"+offerId+" applied to product with product id :"+productId;
	}
	
	// when we want to remove an offer from a product
	@Override
	public String removeOfferFromProduct(Integer offerId, Integer productId) {
		// Fetch the offer by the offer id
		Offer offer=offerRepo.findById(offerId).get();
		// fetch the product by product id
		Product product=productRepo.findById(productId).get();
		
		// removing the entries from both the sides
		offer.removeProduct(product);
		product.removeOffer(offer);
		
		return "offer with offerId"+offerId+" removed from product with product id :"+productId;
	}

	// when we want to delete an offer
	@Override
	public String deleteOffer(Integer offerId) {
		Offer offer=offerRepo.findById(offerId).get();
		List<Product> products=offer.getProducts();
		
		// removing links from both sides 
		offer.setProducts(null);
		for (Product product : products) {
			product.getOffers().remove(offer);
		}
		
		offerRepo.deleteById(offerId);
		return "Offer Deleted Successfully with Offer Id " + offerId;
	}

	

}
