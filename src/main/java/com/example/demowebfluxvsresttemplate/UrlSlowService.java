package com.example.demowebfluxvsresttemplate;

import java.net.URI;
import java.net.URISyntaxException;

public interface UrlSlowService {

	default URI getSlowServiceUri() throws URISyntaxException {
		return new URI(getSlowServiceUriString());
	}
	
	default String getSlowServiceUriString() {
		return "http://localhost/api/slow-service-tweets";
	}
}
