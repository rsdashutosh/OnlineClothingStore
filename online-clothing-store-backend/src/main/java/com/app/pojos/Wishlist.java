package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "wishlist")
public class Wishlist {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wishlist_id")
	private Integer wishlistId;

    @OneToOne(mappedBy = "wishlist")
    private User user;
	
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(joinColumns = {@JoinColumn(name ="wishlist_id",referencedColumnName = "wishlist_id")}, 
	inverseJoinColumns ={@JoinColumn(name = "product_id",referencedColumnName = "product_id")})
	private Set<Product> products=new HashSet<>();
	
	
	// as per Gavin King's IMPORTANT suggestion added helper methods to add/remove child
	public void addProduct(Product product) {
		products.add(product);
		product.addWishlist(this);
	}
	public void removeProduct(Product product) {
		products.remove(product);
		product.getWishlists().remove(this);
	}
	 
}
