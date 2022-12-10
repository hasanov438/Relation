package com.example.demo.files;

import com.example.demo.exception.ControllerExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping
    public void printFile(@RequestParam(name = "document", required = false) MultipartFile[] multipartFile) {
        if (multipartFile != null) {
            Arrays.stream(multipartFile).forEach(this::printMultipleFile);
        }
    }

    public void printMultipleFile(MultipartFile multipartFile) {
        fileService.save(multipartFile);
        if (!multipartFile.isEmpty()) {
            log.info(multipartFile.getOriginalFilename());
            log.info(String.valueOf(multipartFile.getSize()));
        } else {
            throw new ControllerExceptionHandler();
        }
    }

    @GetMapping
    public ResponseEntity<Resource> downloadFile(@RequestParam("fileName") String fileName) {
        Resource file = fileService.download(fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + file.getFilename()).body(file);
    }


}
