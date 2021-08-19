package com.shorturl.changer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class URL {
	@Id
	private String Id;
	private String originalURL;
	private String tinyURL;

	public URL() {
		super();
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getOriginalURL() {
		return originalURL;
	}

	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}

	public String getTinyURL() {
		return tinyURL;
	}

	public void setTinyURL(String tinyURL) {
		this.tinyURL = tinyURL;
	}
	
	
	
}
