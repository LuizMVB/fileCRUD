package com.example.fileCRUD.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Scanner;

@RestController
public class FileController {

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws IOException {
        Scanner reader = new Scanner(file.getInputStream());
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            System.out.println(line);
        }
        reader.close();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
