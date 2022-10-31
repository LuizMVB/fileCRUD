package com.example.fileCRUD;

import com.example.fileCRUD.controllers.FileController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;

@SpringBootTest
class fileCRUDApplicationTest {

	@Test
	void testarUpload() throws IOException {
		FileController controller = new FileController();
		MockMultipartFile multipartFile = new MockMultipartFile(
				"file",
				"hello.txt",
				MediaType.TEXT_PLAIN_VALUE,
				"Hello, World!".getBytes()
		);
		ResponseEntity<?> resp = controller.upload(multipartFile);
		Assert.assertEquals(new ResponseEntity<>(HttpStatus.OK), resp);
	}

}
