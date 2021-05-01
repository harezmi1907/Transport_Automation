package com.example.selenium.helpers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
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
        int freeCount = 2;
        int paidCount = 1;

        List<Map<String, String>> freeStudentsMap = new ArrayList<>();
        List<Map<String, String>> paidStudentsMap = new ArrayList<>();

        for (int i = 0; i < freeCount; i++) {
            freeStudentsMap.add(bigSampleMap.stream().filter(student -> student.get("enrollmentStatus").equals("free")).findAny().get());
        }

        for (int i = 0; i < paidCount; i++) {
            paidStudentsMap.add(bigSampleMap.stream().filter(student -> student.get("enrollmentStatus").equals("paid")).findAny().get());
        }

        System.out.println(freeStudentsMap);
        System.out.println(paidStudentsMap);
    }

    public static List<Map<String, String>> getRandomStudentData(int count, String enrollmentStatus) throws IOException {

        String bigSamplePath = "src\\test\\resources\\BigSample.json";
        List<Map<String, String>> bigSampleMap = mapJson(bigSamplePath) ;
        List<Map<String, String>> students = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            students.add(bigSampleMap.stream().filter(student -> student.get("enrollmentStatus").equals(enrollmentStatus)).findAny().get());
        }

        return students;
    }

    public static List<Map<String, String>> mapJson(String jsonFilePath) throws IOException {
        String file = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
        Type resultType = new TypeToken<List<Map<String, String>>>(){}.getType();

        return new Gson().fromJson(file, resultType);
    }
}
