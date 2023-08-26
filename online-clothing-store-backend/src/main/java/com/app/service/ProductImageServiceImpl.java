package com.app.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import static org.apache.commons.io.FileUtils.writeByteArrayToFile;
import static org.apache.commons.io.FileUtils.readFileToByteArray;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.app.dtos.ProductImageDTO;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.Product;
import com.app.pojos.ProductImage;
import com.app.repository.ProductImageRepository;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductImageServiceImpl implements ProductImageService {

	//setting the value from application.properties
	@Value("${file.upload.location}")
	private String uploadFolder;
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ProductImageRepository productImageRepo;
	
	@Autowired
	private ProductRepository productRepo;

	// making sure the folder "images/" exists
	@PostConstruct
	public void init() throws IOException {
		// chk if folder exists --yes --continue
		File folder = new File(uploadFolder);
		if (folder.exists()) {
			System.out.println("folder exists alrdy !");
		} else {
			// no --create a folder
			folder.mkdir();
			System.out.println("created a folder !");
		}
	}
	
	
	// POST
	@Override
	public String addProductImage(ProductImageDTO productImageDTO) throws IOException {
		// fetching the product
		Product product=productRepo.findById(productImageDTO.getProductId()).orElseThrow(() -> new ResourceNotFoundException("product with not found "));
		
		// store the image on server side folder
		String path = uploadFolder.concat(productImageDTO.getImage().getOriginalFilename());
		// Use FileUtils method : writeByte[] --> File
		writeByteArrayToFile(new File(path), productImageDTO.getImage().getBytes());
		
		// Mapping the DTO to object of ProductImage class 
	 	ProductImage productImage=mapper.map(productImageDTO, ProductImage.class);	
		ProductImage persistentProductImage=productImageRepo.save(productImage);
		
		// set image path
		persistentProductImage.setImagePath(path);		
				
		// linking ProductImage with Product
		persistentProductImage.setImage(productImageDTO.getImage().getBytes()); // not required now as we have already stored the image in the project folder
		persistentProductImage.setProduct(product);
		product.addProductImage(persistentProductImage);
		
		return persistentProductImage.getName()+" image added !";
	}

	// Get productImage by Id
	@Override
	public byte[] getProductImage(Integer productId,Integer ImageId) throws IOException {
		ProductImage productImage = productImageRepo.findById(ImageId).orElseThrow(()-> new ResourceNotFoundException("product image does not exist!"));
		// 1st method
		//ProductImageDTO productImageDto = mapper.map(productImage, ProductImageDTO.class);
		//return productImage.getImage();
		
		// 2nd method
		String path=productImage.getImagePath();
		if(path!=null){
			return readFileToByteArray(new File(path));
		}else
		{
			throw new ResourceNotFoundException("Image could not be found");
		}
		
	}

	// Get all productImages
	@Override
	public List<String> getAllProductImages(Integer productId) {
		//finding the product by product id
		Product product=productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("product does not exist!"));
		
		// fetching all the images of a product
		List<ProductImage> productImages=productImageRepo.findByProduct(product);
		
		return productImages.stream().map(productImage->productImage.getImagePath()).collect(Collectors.toList());

		
	}

	// Update product image
	@Override
	public String updateProductImageDetails(Integer productImageId, ProductImageDTO productImageDTO) throws IOException {
		ProductImage persistentProductImage = productImageRepo.findById(productImageId).get();
		mapper.map(productImageDTO, persistentProductImage);
		//persistentProductImage.setImage(productImageDTO.getImage().getBytes());
		return persistentProductImage.getName()+" Updated!";
	}
	

	//Delete a product image
	@Override
	public String deleteProductImage(Integer productImageId) {
		// fetching the image
		ProductImage productImage=productImageRepo.findById(productImageId).get();
		// fetching the product
		Product product=productRepo.findById(productImage.getProduct().getId()).get();
		product.getProductImages().remove(productImage);
		productImage.setProduct(null);
		
		productImageRepo.deleteById(productImageId);
		return "ProductImage : "+productImageId+" deleted Successfully!";
	}

}
