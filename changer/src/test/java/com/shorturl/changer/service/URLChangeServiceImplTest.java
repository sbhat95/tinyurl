/**
 * 
 */
package com.shorturl.changer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shorturl.changer.model.URL;
import com.shorturl.changer.repository.URLRepository;

/**
 * @author Sai Bhat
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class URLChangeServiceImplTest {

	@MockBean
	private URLRepository repository;
	
	private URLChangeServiceImpl  urlService =null;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
			urlService = new URLChangeServiceImpl();
	}

	/**
	 * Test method for {@link com.shorturl.changer.service.URLChangeServiceImpl#generateURL(com.shorturl.changer.model.URL, java.lang.String)}.
	 */
	@Test
	@DisplayName("Testing generateURL method")
	@Order(1)
	void testGenerateURL() {
		URL url = new URL();
		String expected = "http://58f3ae21.com";
		String originalURL = "http://google.com";
		String actual = urlService.generateURL(url, originalURL);
		assertEquals(expected, actual, "This method generates a tiny URL");
	}

	/**
	 * Test method for {@link com.shorturl.changer.service.URLChangeServiceImpl#getOriginalURL(java.lang.String)}.
	 */
	@Test
	@DisplayName("Testing getOriginalURL method")
	@Order(2)
	void testGetOriginalURL() {
		String tinyURL = "http://58f3ae21.com";
		String expected = "http://google.com";
		String actual = urlService.getOriginalURL(tinyURL);
		assertEquals(expected, actual, "This method generates a tiny URL");
	}

}
