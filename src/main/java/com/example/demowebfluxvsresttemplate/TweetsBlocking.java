package com.example.demowebfluxvsresttemplate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class TweetsBlocking implements UrlSlowService {

	private Logger log = LoggerFactory.getLogger(TweetsNonBlocking.class);
	
	@GetMapping("/tweets-blocking")
	public List<Tweet> getTweetsBlocking() {
		log.info("Starting BLOCKING Controller!");
		final String uri = getSlowServiceUriString();

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Tweet>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Tweet>>() {
				});

		List<Tweet> result = response.getBody();
		result.forEach(tweet -> log.info(tweet.toString()));
		log.info("Exiting BLOCKING Controller!");
		return result;
	}
}
