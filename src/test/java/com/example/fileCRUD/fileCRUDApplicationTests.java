package com.example.fileCRUD;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;

@SpringBootTest
class fileCRUDApplicationTests {

	@Test
	void testarUpload() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		MultiValueMap<String, Object> body
				= new LinkedMultiValueMap<>();
		File file = new File("teste.txt");
		file.createNewFile();
		body.add("file", file);

		HttpEntity<MultiValueMap<String, Object>> requestEntity
				= new HttpEntity<>(body, headers);

		String serverUrl = "http://localhost:8080/file/upload";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate
				.postForEntity(serverUrl, requestEntity, String.class);

	}

}
