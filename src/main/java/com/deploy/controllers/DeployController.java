package com.deploy.controllers;

import com.deploy.entity.FileEntry;
import com.deploy.services.FileEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class DeployController {

    @Autowired
    FileEntryService fileEntryService;

    @GetMapping("/test")
    public String test(HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        return "test";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/upload", headers = "content-type=multipart/*", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile multipartFile, HttpServletResponse response) throws IOException {
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
     //   response.addHeader("Accept", "*/*");
     //   response.addHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);
      //  response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
      //  response.addHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia");
        fileEntryService.addData(multipartFile);
        return fileEntryService.addData(multipartFile);
    }

    @GetMapping("/getclient/{name}")
    public List<FileEntry> getClientByName(@PathVariable String name, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        return fileEntryService.getClientByName(name);
    }

    @GetMapping("/getAll")
    public List<FileEntry> getAll(HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        List<FileEntry> list = fileEntryService.findAll();
        return list;
    }
}
