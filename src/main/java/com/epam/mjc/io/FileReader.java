package com.epam.mjc.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
public class FileReader {
    private static final Logger LOGGER = Logger.getLogger(FileReader.class.getName());

    public Profile getDataFromFile(File file) {
        Map<String, String> profileMap = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new java.io.FileReader(file))){
            String line;
            while((line = br.readLine()) != null){
                var parts = line.split(": ");
                if(parts.length == 2){
                    profileMap .put(parts[0].trim(), parts[1].trim());
                }
            }
        }
        catch (IOException e){
            LOGGER.log(Level.SEVERE, "Error occurred while reading the file.", e);
        }
        return new Profile(profileMap .get("Name"), Integer.parseInt(profileMap .get("Age")), profileMap .get("Email"), Long.parseLong(profileMap .get("Phone")));
    }
}
