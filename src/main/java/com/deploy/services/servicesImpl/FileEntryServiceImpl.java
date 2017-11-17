package com.deploy.services.servicesImpl;

import com.deploy.entity.Client;
import com.deploy.entity.FileEntry;
import com.deploy.entity.FileMetaData;
import com.deploy.entity.Requirement;
import com.deploy.repository.ClientJpa;
import com.deploy.repository.FileEntryJpa;
import com.deploy.repository.FileMetaDataJpa;
import com.deploy.repository.RequirementJpa;
import com.deploy.services.FileEntryService;
import com.deploy.util.EntityUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class FileEntryServiceImpl implements FileEntryService {

    @Autowired
    FileEntryJpa fileEntryJpa;

    @Autowired
    ClientJpa clientJpa;

    @Autowired
    FileMetaDataJpa fileMetaDataJpa;

    @Autowired
    RequirementJpa requirementJpa;

    @Override
    public String addData(MultipartFile multipartFile){
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(multipartFile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet sheet=workbook.getSheetAt(0);
        Row row;
        Cell cell;
        List<String> properties = new ArrayList<>();

        List<FileEntry> fileEntries = new ArrayList<>();
        List<Client> clientEntries = new ArrayList<>();
        List<Requirement> requirementEntries = new ArrayList<>();
        List<FileMetaData> fileMetaDataEntries = new ArrayList<>();

        Iterator rows = sheet.rowIterator();

        while (rows.hasNext()) {

            FileEntry fileEntry = new FileEntry();
            Client clientEntry = new Client();
            Requirement requirementEntry = new Requirement();
            FileMetaData fileMetaDataEntry = new FileMetaData();

            row=(Row) rows.next();
            if (row.getRowNum() == 0)
                continue;
            Iterator cells = row.cellIterator();
            while (cells.hasNext()) {
                cell=(Cell) cells.next();
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    properties.add(cell.getStringCellValue());
                } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    properties.add(String.valueOf(cell.getNumericCellValue()));
                }
            }
            fileEntry = EntityUtil.setAllFields(properties, fileEntry);
            clientEntry = EntityUtil.setAllFields(properties, clientEntry);
            requirementEntry = EntityUtil.setAllFields(properties, requirementEntry);
            fileMetaDataEntry = EntityUtil.setAllFields(properties, fileMetaDataEntry);

            fileEntries.add(fileEntry);
            clientEntries.add(clientEntry);
            requirementEntries.add(requirementEntry);
            fileMetaDataEntries.add(fileMetaDataEntry);

            System.out.println(fileEntry);
            System.out.println();
            properties.clear();
        }

        System.out.println(fileEntries);

        fileEntryJpa.save(fileEntries);
        clientJpa.save(clientEntries);
        requirementJpa.save(requirementEntries);
        fileMetaDataJpa.save(fileMetaDataEntries);

        return "OK";
    }

    @Override
    public List<FileEntry> getClientByName(String name) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable page = new PageRequest(0,10, sort);
        List lista = fileEntryJpa.findByClientNameLike(name +"%", page);

        return lista;
    }

    @Override
    public List<FileEntry> findAll() {
        return fileEntryJpa.findAll();
    }


}
