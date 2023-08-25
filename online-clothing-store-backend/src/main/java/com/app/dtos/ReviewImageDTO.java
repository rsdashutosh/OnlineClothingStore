 package com.app.dtos;
import org.springframework.web.multipart.MultipartFile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewImageDTO {

	private String name;
	
	private MultipartFile image;
	
	// review id
	private Integer reviewId;
	
}
