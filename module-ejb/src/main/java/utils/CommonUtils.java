package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jankovicsandras.imagetracer.ImageTracer;
import name.suchanek.Svg2Ttf;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Base64;
import java.util.List;

public class CommonUtils {

    public static byte[] fileToByteArray(String path) {
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
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

    public static String encodeByteArrayToBase64(byte[] array) {
        return Base64.getEncoder().encodeToString(array);
    }

    public static byte[] decodeBase64ToByteArray(String base64) {
        System.out.println(base64);
        return Base64.getDecoder().decode(base64.getBytes(StandardCharsets.UTF_8));
    }

//    public static File createSVGFile(String name, byte[] figure) {
//        BufferedImage bufferedImage = convertByteArrayToBufferedImage(figure);
//        String svg = convertRasterToSVG(bufferedImage);
//        File file = new File("module-ejb/src/main/resources/tempSVG/" + name + ".svg");
//        boolean fileCreated = false;
//        try {
//            if (!file.exists()) {
//                fileCreated = file.createNewFile();
//            }
//            FileWriter fw = new FileWriter(file);
//            BufferedWriter bw = new BufferedWriter(fw);
//            bw.write(svg);
//            bw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return file;
//    }

//    public static String createSVGAsString(byte[] figure) {
//        BufferedImage bufferedImage = convertByteArrayToBufferedImage(figure);
//        return convertRasterToSVG(bufferedImage);
//    }

    public static void createTTFFile(File file, String designer, String designerURL) {
        try {
            Svg2Ttf.convert(file, designer, designerURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static BufferedImage convertByteArrayToBufferedImage(byte[] array) {
        BufferedImage bufferedImage = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(array);
            bufferedImage = ImageIO.read(bis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }

//    public static String convertRasterToSVG(BufferedImage bufferedImage) {
//        String svg = null;
//        try {
//            svg = ImageTracer.imageToSVG(bufferedImage,null,null);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return svg;
//    }



}
