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
	public OfferDTO addOffer(OfferDTO offerDTO) {

		Offer offer = mapper.map(offerDTO, Offer.class);
		Offer persistantOffer = offerRepo.save(offer);

		return mapper.map(persistantOffer, OfferDTO.class);

	}

	@Override
	public OfferDTO updateOffer(OfferDTO offerDTO, Integer offerId) {
		Offer offer = offerRepo.findById(offerId)
				.orElseThrow(() -> new ResourceNotFoundException("Offer", "Id", offerId));
<<<<<<< HEAD
		mapper.map(offerDto, offer);
		return offerDto;
=======
		OfferDTO updatedOfferDTO = mapper.map(offer, OfferDTO.class);
		return updatedOfferDTO;
>>>>>>> 26742714990dfba5ed8ccae792be39cbc020dee3
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

}
