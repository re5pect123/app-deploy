package com.deploy.repository;

import com.deploy.entity.FileEntry;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FileEntryJpa extends JpaRepository<FileEntry, Integer>{

    List findByClientNameLike(String name, Pageable page);
    List <FileEntry> findAll();
}
