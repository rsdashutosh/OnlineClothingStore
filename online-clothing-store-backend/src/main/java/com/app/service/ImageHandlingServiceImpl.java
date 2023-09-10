package com.app.service;

import static org.apache.commons.io.FileUtils.readFileToByteArray;
import static org.apache.commons.io.FileUtils.writeByteArrayToFile;
import java.io.File;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.app.pojos.Product;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ImageHandlingServiceImpl implements ImageHandlingService {
	// injecting value of the field read from applicatoin.properties file
	@Value("${file.upload.location}") // field level DI , <property name n value />
	// ${file.upload.location} SpEL :Spring expr language
	private String uploadFolder;

	@Autowired
	private ProductRepository productRepo;

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

	@Override
	public String uploadImage(Integer productId, MultipartFile image) throws IOException {
		// get product from product id
		Product product = productRepo.findById(productId).get();
		// product found --> PERSISTENT
		// store the image on server side folder
		// "images/" + "red_jacket.png" => path="images/red_jacket.png"
		String path = uploadFolder.concat(image.getOriginalFilename());
		
		System.out.println(path);
		// Use FileUtils method : writeByte[] --> File
		writeByteArrayToFile(new File(path), image.getBytes());
		// set image path
		product.setImagePath(path);
		// OR to store the img directly in DB as a BLOB
		// product.setImage(image.getBytes());
		return "Image file uploaded successfully for product id " + productId;
	}

	@Override
	public byte[] serveImage(Integer productId) throws IOException {
		// get emp by id
		Product product = productRepo.findById(productId).get();
		// emp found --> PERSISTENT
		String path = product.getImagePath();
		if (path != null) {
			// path ---> File --> byte[]
			return readFileToByteArray(new File(path));
			//OR from DB : return emp.getImage();
		} else
			throw new com.app.exception.ResourceNotFoundException("Image not yet assigned !!!!");


	}

}
