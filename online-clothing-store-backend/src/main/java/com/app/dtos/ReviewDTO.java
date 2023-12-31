package com.app.dtos;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.app.pojos.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO 
{
	@NotBlank(message = "review title is mandatory")
	private String title;
	
	@NotBlank(message = "review description is mandatory")
	private String description;
	
	@NotNull(message = "review rating is mandatory")
	//@Size(min = 1,max = 10)
	private Integer rating;
	
	@NotNull(message = "user Id is mandatory")
	private Integer userId;
		
	private Integer productId;
	
	// one review can have multiple images 
	//private List<Byte[]> reviewImages;

}
