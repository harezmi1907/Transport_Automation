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
import java.util.stream.Collectors;

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
        int freeCount = 7;

        List<Map<String, String>> freeStudentsMap = bigSampleMap.stream()
                .filter(student -> student.get("enrollmentStatus").equals("free"))
                .collect(Collectors.toList())
                .stream().limit(freeCount).collect(Collectors.toList());

        System.out.println(freeStudentsMap);
    }

    /**
     *
     * @param count
     * @param enrollmentStatus (free or paid)
     * @return
     * @throws IOException
     */
    public static List<Map<String, String>> getRandomStudentData(int count, String enrollmentStatus) throws IOException {

        String bigSamplePath = "src\\test\\resources\\BigSample.json";

        return mapJson(bigSamplePath)
                .stream()
                .filter(student -> student.get("enrollmentStatus").equals(enrollmentStatus))
                .collect(Collectors.toList())
                .stream()
                .limit(count)
                .collect(Collectors.toList());

    }

    /**
     *
     * @param jsonFilePath
     * @return serialized Json file
     * @throws IOException
     */
    public static List<Map<String, String>> mapJson(String jsonFilePath) throws IOException {
        String file = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
        Type resultType = new TypeToken<List<Map<String, String>>>(){}.getType();

        return new Gson().fromJson(file, resultType);
    }
}
