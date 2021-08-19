package com.shorturl.changer.service;

import org.springframework.stereotype.Service;

import com.shorturl.changer.model.URL;

@Service
public interface URLChangeService {
	
	public String generateURL(URL url, String originalURL);
	public String getOriginalURL(String tinyURL);
}
