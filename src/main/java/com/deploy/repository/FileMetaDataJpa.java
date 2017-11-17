package com.deploy.repository;

import com.deploy.entity.FileMetaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileMetaDataJpa extends JpaRepository<FileMetaData, Integer> {
}
