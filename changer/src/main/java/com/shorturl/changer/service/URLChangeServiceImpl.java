package com.shorturl.changer.service;

import java.nio.charset.StandardCharsets;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.shorturl.changer.model.URL;
import com.shorturl.changer.repository.URLRepository;

@Service
public class URLChangeServiceImpl implements URLChangeService {

	private static final String SUFFIX = ".com";
	private static final String PREFIX = "http://";
	
	@Autowired
	URLRepository repository;

	@Override
	public String generateURL(URL url, String originalURL) {
		UrlValidator urlValidator = new UrlValidator(
                new String[]{"http", "https"}
        );

		if (urlValidator.isValid(originalURL)) {
			String id = PREFIX+
						Hashing.murmur3_32().
						hashString(originalURL, StandardCharsets.UTF_8).
						toString()+SUFFIX;
			System.out.println("URL Id generated: " + id);
			url.setTinyURL(id);
			url.setId(id);
			url.setOriginalURL(originalURL);
			repository.save(url);
			return id;
		}

        throw new RuntimeException("URL Invalid: " + url);
	}

	@Override
	public String getOriginalURL(String tinyURL) {
		
		URL retrievedUrl = repository.getById(tinyURL);
        System.out.println("URL Retrieved: " + retrievedUrl.getTinyURL());

        if (retrievedUrl.getTinyURL() == null) {
            throw new RuntimeException("There is no shorter URL for : " + retrievedUrl.getOriginalURL());
        }
        return retrievedUrl.getOriginalURL();
	}

}
