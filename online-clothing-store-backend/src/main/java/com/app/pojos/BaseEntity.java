package com.app.pojos;

import javax.persistence.*;


@MappedSuperclass // to tell hib , not to create any tables n other entities will extend from it
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
