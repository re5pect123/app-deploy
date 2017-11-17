package com.deploy.util;

import com.deploy.entity.Client;
import com.deploy.entity.FileEntry;
import com.deploy.entity.FileMetaData;
import com.deploy.entity.Requirement;

import java.util.List;

public class EntityUtil {

    public static FileEntry setAllFields(List<String> properties, FileEntry fileEntry) {
        for (int i = 0; i < properties.size(); i++) {
            switch (i) {
                case 0:
                    fileEntry.setClientName(properties.get(i));
                    break;
                case 1:
                    fileEntry.setClientId(properties.get(i));
                    break;
                case 2:
                    fileEntry.setInputDate(properties.get(i));
                    break;
                case 3:
                    fileEntry.setAmount(properties.get(i));
                    break;
                case 4:
                    fileEntry.setFileMetaDataId(properties.get(i));
                    break;
                case 5:
                    fileEntry.setSource(properties.get(i));
                    break;

            }
        }
        return fileEntry;
    }


    public static Client setAllFields(List<String> properties, Client client) {
        for (int i = 0; i < properties.size(); i++) {
            switch (i) {
                case 0:
                    client.setClientName(properties.get(i));
                    break;
                case 1:
                    client.setClientId(properties.get(i));
                    break;
            }
        }
        return client;
    }

    public static Requirement setAllFields(List<String> properties, Requirement requirement) {
        for (int i = 0; i < properties.size(); i++) {
            switch (i) {
                case 0:
                    requirement.setClientId(properties.get(i));
                    break;
                case 1:
                    requirement.setAmount(properties.get(i));
                    break;
                case 2:
                    requirement.setInputDate(properties.get(i));
                    break;
                case 3:
                    requirement.setFileMetaDataId(properties.get(i));
                    break;

            }
        }
        return requirement;
    }

    public static FileMetaData setAllFields(List<String> properties, FileMetaData fileMetaData) {
        for (int i = 0; i < properties.size(); i++) {
            switch (i) {
                case 0:
                    fileMetaData.setFileMetaDataId(properties.get(i));
                    break;
                case 1:
                    fileMetaData.setFileName(properties.get(i));
                    break;
                case 2:
                    fileMetaData.setSourceId(properties.get(i));
                    break;
                case 3:
                    fileMetaData.setProvider(properties.get(i));
                    break;

            }
        }
        return fileMetaData;
    }
}
