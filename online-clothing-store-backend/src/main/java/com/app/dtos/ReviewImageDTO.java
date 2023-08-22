 package com.app.dtos;

import javax.persistence.Lob;
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
	
	@Lob // large object :col : longblob
	private Byte[] image;
	
	// review id
	private Integer reviewId;
	
}
