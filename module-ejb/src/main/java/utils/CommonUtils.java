package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Culture;
import entity.Language;
import entity.Symbol;
import logic.name.generation.Letter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CommonUtils {

    public static byte[] fileToByteArray(String path) {
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch(IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public static boolean isFileExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    public static String getAbsolutePath() {
        File file = new File(".");
        return file.getAbsolutePath();
    }

    public static String convertObjectToJson(Object object) {
        String jsonString = "";
        try {
            jsonString = new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public static String convertListOfObjectsToJson(List<?> objects) {
        String jsonString = "";
        try {
            jsonString = new ObjectMapper().writeValueAsString(objects);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
