package com.app.service;

import java.util.List;
import com.app.dtos.ShippingDTO;

public interface ShippingService
{
	public String addShipping(ShippingDTO shippingDTO);
	public ShippingDTO getShipping(Integer shippingId);
	public List<ShippingDTO> getAllShippings();
	public String deleteShipping(Integer shippingId);
	public String editShipping(Integer shippingId,ShippingDTO shippingDTO);

}
