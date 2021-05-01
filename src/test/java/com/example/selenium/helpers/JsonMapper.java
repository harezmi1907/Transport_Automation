package com.example.selenium.helpers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * @author ykeskin
 * @since 5/1/2021
 */
public class JsonMapper {


    public static void main(String[] args) throws IOException {
        String BigSamplePath = "src\\test\\resources\\BigSample.json";
        String file = FileUtils.readFileToString(new File(BigSamplePath), StandardCharsets.UTF_8);
        Type resultType = new TypeToken<List<Map<String, String>>>(){}.getType();
        List<Map<String, String>> bigSampleMap = new Gson().fromJson(file, resultType);

        System.out.println(bigSampleMap.get(0));
    }

    public static List<Map<String, String>> mapJson(String jsonFilePath) throws IOException {
        String file = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
        Type resultType = new TypeToken<List<Map<String, String>>>(){}.getType();

        return new Gson().fromJson(file, resultType);
    }
}
