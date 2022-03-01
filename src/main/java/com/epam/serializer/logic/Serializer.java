package com.epam.serializer.logic;

import com.epam.serializer.entity.Person;
import com.epam.serializer.entity.Public;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Serializer {

    public void writeJson(String filename, Person person) throws Exception {

        Map<String, Field> map = new HashMap<>();
        JSONObject sampleObject = new JSONObject();
        Class personClass = person.getClass();

        for(Field field : personClass.getDeclaredFields()){
            Public annotation = field.getAnnotation(Public.class);
            if(annotation != null){
                field.setAccessible(true);
                map.put(field.getName(), field);
            }
        }

        for(Map.Entry<String, Field> m : map.entrySet()){
            sampleObject.put(m.getKey(), m.getValue().get(person));
        }

        Files.write(Paths.get(filename), sampleObject.toJSONString().getBytes());
    }
}
