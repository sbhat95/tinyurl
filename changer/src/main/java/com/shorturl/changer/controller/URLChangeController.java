package com.shorturl.changer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shorturl.changer.model.URL;
import com.shorturl.changer.service.URLChangeService;

@RestController
@RequestMapping("/tinyurl")
public class URLChangeController {
	
	@Autowired
	URLChangeService service;
	
	@PostMapping("/create") 
	private String postURL(@RequestBody String url) {
		URL urlModel = new URL();
		return service.generateURL(urlModel, url);
	}
	
	@PostMapping("/fetch")
	private String fetchURL(@RequestBody String url) {
		return service.getOriginalURL(url);
	}
}
