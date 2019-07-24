package com.example.demowebfluxvsresttemplate;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class SlowServiceTweets {

	@GetMapping("/slow-service-tweets")
	private List<Tweet> getAllTweets() throws InterruptedException {
	    Thread.sleep(2000L); // delay
	    return Arrays.asList(
	      new Tweet("RestTemplate rules", "@user1"),
	      new Tweet("WebClient is better", "@user2"),
	      new Tweet("OK, both are useful", "@user1"));
	}
}
