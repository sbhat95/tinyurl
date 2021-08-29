package com.shorturl.changer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shorturl.changer.model.URL;
import com.shorturl.changer.service.URLChangeService;

@RestController
@RequestMapping("/tinyurl")
public class URLChangeController {
	
	@Autowired
	URLChangeService service;
	
	@GetMapping("/create")
	private String createURL(@RequestParam(name = "url") String url) {
		  URL urlModel = new URL(); 
		  return service.generateURL(urlModel, url);
		 
	}
	
	@GetMapping("/fetch")
	private String getURL(@RequestParam(name = "url") String url) {
		return service.getOriginalURL(url);
		 
	}
	
}
