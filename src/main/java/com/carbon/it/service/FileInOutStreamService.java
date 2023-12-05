package com.carbon.it.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class FileInOutStreamService {

    public static final Logger LOGGER = Logger.getLogger(FileInOutStreamService.class.getName());
    public static List<String> readDataFromFile(String filename)  {

        String filePath = Objects
                .requireNonNull(FileInOutStreamService
                        .class
                        .getClassLoader()
                        .getResource(filename))
                .getPath();

        try {
            if(filePath == null || filePath.isEmpty()) {
                throw new RuntimeException("File path not found");
            }
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            LOGGER.severe("Cannot Find file or Error Occurred while attempting to read file");
        }
        return null;
    }

    public static void writeOutputFile(List<String> list, String fileName)  {

        if (fileName == null || fileName.equals("")) {
            LOGGER.info("Cannot create file without file name");
            return;
        }

        if (list == null || list.isEmpty()) {
            LOGGER.info("List is empty or null");
            return;
        }
        PrintWriter printWriter = null;
        try {

            FileWriter fileWriter = new FileWriter(fileName);
            printWriter = new PrintWriter(fileWriter);

            for (String str : list) {
                printWriter.println(str);
            }
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
