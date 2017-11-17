package com.deploy.entity;


import javax.persistence.Entity;

@Entity
public class FileEntry extends  BaseEntity{

    private String clientName;

    private String clientId;

    private String inputDate;

    private String amount;

    private String fileMetaDataId;

    private String source;

    public FileEntry() {

    }

    public FileEntry(String clientName, String clientId, String inputDate, String amount, String fileMetaDataId,
                     String source) {
        this.clientName = clientName;
        this.clientId = clientId;
        this.inputDate = inputDate;
        this.amount = amount;
        this.fileMetaDataId = fileMetaDataId;
        this.source = source;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFileMetaDataId() {
        return fileMetaDataId;
    }

    public void setFileMetaDataId(String fileMetaDataId) {
        this.fileMetaDataId = fileMetaDataId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    //clientName	clientId	inputDate	amount	fileMetaDataId	source
    public String toString() {
        return "New Object -- Client name: " + clientName + ", " + "Client id: " + clientId + ", Input date" + inputDate +
                ", " + "amount: " + amount + ", Source: " + source;
    }
}
