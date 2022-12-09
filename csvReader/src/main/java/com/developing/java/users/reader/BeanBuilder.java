package com.developing.java.users.reader;

import com.developing.java.users.domain.UserBean;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class BeanBuilder {

    public void reader() throws IOException {

        URL url = new URL("https://pastebin.com/raw/miWfmfVX");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        CSVParser csvParser = new CSVParserBuilder()
                .withSeparator(';')
                .withIgnoreQuotations(true)
                .build();

        CsvToBean csvToBean = new CsvToBeanBuilder(in)
                .withSeparator(';')
                .build();
        csvToBean.setMappingStrategy(setColumMapping());

        CSVReader csvReader = new CSVReaderBuilder(in)
                .withCSVParser(csvParser)
                .build();
        csvToBean.setCsvReader(csvReader);  //?
        //csvReader.getParser().getPendingText();

        List list = csvToBean.parse();

        for (Object object : list) {
            UserBean user = (UserBean) object;
            System.out.println(user);
        }
    }

    private static ColumnPositionMappingStrategy setColumMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(UserBean.class);
        String[] columns = new String[]{"first_name", "last_name", "birth_date", "phone_no"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}
