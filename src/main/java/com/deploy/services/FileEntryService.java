package com.deploy.services;

import com.deploy.entity.FileEntry;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface FileEntryService {

    String addData(MultipartFile multipartFile);

    List<FileEntry> getClientByName(String name);

    List<FileEntry> findAll();

}
