package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.OfferDto;
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
	public OfferDto addOffer(OfferDto offerDto) {

		Offer offer = mapper.map(offerDto, Offer.class);
		Offer persistantOffer = offerRepo.save(offer);

		return mapper.map(persistantOffer, OfferDto.class);

	}

	@Override
	public OfferDto updateOffer(OfferDto offerDto, Integer offerId) {
		Offer offer = offerRepo.findById(offerId)
				.orElseThrow(() -> new ResourceNotFoundException("Offer", "Id", offerId));
			mapper.map(offerDto, offer);
			return offerDto;
	}

	@Override
	public String deleteOffer(Integer offerId) {
		offerRepo.deleteById(offerId);
		return "Offer Deleted Successfully with Offer Id " + offerId;
	}

	@Override
	public OfferDto getOffer(Integer offerId) {
		Offer offer = offerRepo.findById(offerId)
				.orElseThrow(() -> new ResourceNotFoundException("Offer", "Id", offerId));
		OfferDto offerDto = mapper.map(offer, OfferDto.class);
		return offerDto;
	}

	@Override
	public List<OfferDto> getAllOffer() {
		List<Offer> offers = offerRepo.findAll();
		List<OfferDto> offerDtos = offers.stream().map(offer -> mapper.map(offer, OfferDto.class))
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
