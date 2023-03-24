package com.jeremias.dev.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jeremias.dev.response.FileStatusResponse;

import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
public class FileControlleer {
	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "C:\\Temp";

  

    @PostMapping("/upload") 
    public FileStatusResponse singleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            
           return new FileStatusResponse(false,"Por favor seleccione el file a subir");
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path dir = Paths.get(UPLOADED_FOLDER);
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            // Create parent dir if not exists
            if(!Files.exists(dir)) {
                Files.createDirectories(dir);
            }
            Files.write(path, bytes);
            log.info("todo okeru:  ");
            //or we can save in bd with blob 
        } catch (IOException e) {
        	
           log.error("error of ioexcpetion :  " + e.getMessage());
            e.printStackTrace();
        }
        return new FileStatusResponse(true,"OK");
    }

 
	
}
