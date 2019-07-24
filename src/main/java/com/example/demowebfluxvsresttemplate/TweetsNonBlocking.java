package com.example.demowebfluxvsresttemplate;

import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class TweetsNonBlocking implements UrlSlowService {

	private Logger log = LoggerFactory.getLogger(TweetsNonBlocking.class);

	@GetMapping(value = "/tweets-non-blocking", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tweet> getTweetsNonBlocking() throws URISyntaxException {
		log.info("Starting NON-BLOCKING Controller!");
		Flux<Tweet> tweetFlux = WebClient.create().get().uri(getSlowServiceUri()).retrieve().bodyToFlux(Tweet.class);

		tweetFlux.subscribe(tweet -> log.info(tweet.toString()));
		log.info("Exiting NON-BLOCKING Controller!");
		return tweetFlux;
	}

}
