package com.deploy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "REQUIREMENT")
public class Requirement extends BaseEntity {

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "amount")
    private String amount;

    @Column(name = "input_date")
    private String inputDate;

    @Column(name = "file_meta_data_id")
    private String fileMetaDataId;

    public Requirement() {
    }

    public Requirement(String clientId, String amount, String inputDate, String fileMetaDataId) {
        this.clientId = clientId;
        this.amount = amount;
        this.inputDate = inputDate;
        this.fileMetaDataId = fileMetaDataId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getFileMetaDataId() {
        return fileMetaDataId;
    }

    public void setFileMetaDataId(String fileMetaDataId) {
        this.fileMetaDataId = fileMetaDataId;
    }
}
