package com.deploy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FILE_META_DATA")
public class FileMetaData extends BaseEntity {

    @Column(name = "file_meta_data_id")
    private String fileMetaDataId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "source_id")
    private String sourceId;

    @Column(name = "provider")
    private String provider;

    public FileMetaData() {
    }

    public FileMetaData(String fileMetaDataId, String fileName, String sourceId, String provider) {
        this.fileMetaDataId = fileMetaDataId;
        this.fileName = fileName;
        this.sourceId = sourceId;
        this.provider = provider;
    }

    public String getFileMetaDataId() {
        return fileMetaDataId;
    }

    public void setFileMetaDataId(String fileMetaDataId) {
        this.fileMetaDataId = fileMetaDataId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
