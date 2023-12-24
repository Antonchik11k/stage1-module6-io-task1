package com.epam.mjc.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Map<String, String> profile_info = new HashMap<>();
        try(BufferedReader br = new BufferedReader(new java.io.FileReader(file))){
            String line;
            while((line = br.readLine()) != null){
                var parts = line.split(": ");
                if(parts.length == 2){
                    profile_info.put(parts[0].trim(), parts[1].trim());
                }
            }
        }
        catch (IOException e){

        }
        return new Profile(profile_info.get("Name"), Integer.parseInt(profile_info.get("Age")), profile_info.get("Email"), Long.parseLong(profile_info.get("Phone")));
    }
}
