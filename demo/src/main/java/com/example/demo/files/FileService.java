package com.example.demo.files;

import com.example.demo.exception.ControllerExceptionHandler;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

@Service
public class FileService {
    private final Path root = Path.of("uploads");

    public void save(MultipartFile multipartFile) {

        try {
            multipartFile.transferTo(this.root.resolve(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Resource download(String fileName) {
        try {
            Resource resource = new UrlResource(this.root.resolve(fileName).toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new ControllerExceptionHandler();
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
