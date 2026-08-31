package com.api.utils;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JsonReader {

    public static <T> T getData(String fileName, Class<T> clazz) throws FileNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.readValue(new File(fileName),clazz);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
