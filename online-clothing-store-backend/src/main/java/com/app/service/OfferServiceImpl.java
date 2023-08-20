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
import com.app.repository.OfferRepository;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private OfferRepository offerRepo;

	@Override
	public OfferDTO addOffer(OfferDTO offerDto) {

		Offer offer = mapper.map(offerDto, Offer.class);
		Offer persistantOffer = offerRepo.save(offer);

		return mapper.map(persistantOffer, OfferDTO.class);

	}

	@Override
	public OfferDTO updateOffer(OfferDTO offerDto, Integer offerId) {
		Offer offer = offerRepo.findById(offerId)
				.orElseThrow(() -> new ResourceNotFoundException("Offer", "Id", offerId));
<<<<<<< HEAD
		OfferDTO updatedOfferDto = mapper.map(offer, OfferDTO.class);
		return updatedOfferDto;
=======
			mapper.map(offerDto, offer);
			return offerDto;
>>>>>>> 59fbfa4ea447ca4f61a5a725a90c341440bc5ef7
	}

	@Override
	public String deleteOffer(Integer offerId) {
		offerRepo.deleteById(offerId);
		return "Offer Deleted Successfully with Offer Id " + offerId;
	}

	@Override
	public OfferDTO getOffer(Integer offerId) {
		Offer offer = offerRepo.findById(offerId)
				.orElseThrow(() -> new ResourceNotFoundException("Offer", "Id", offerId));
		OfferDTO offerDto = mapper.map(offer, OfferDTO.class);
		return offerDto;
	}

	@Override
	public List<OfferDTO> getAllOffer() {
		List<Offer> offers = offerRepo.findAll();
		List<OfferDTO> offerDtos = offers.stream().map(offer -> mapper.map(offer, OfferDTO.class))
				.collect(Collectors.toList());
		return offerDtos;
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

}
