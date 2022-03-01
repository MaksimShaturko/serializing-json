package com.epam.serializer.main;

import com.epam.serializer.entity.Person;
import com.epam.serializer.logic.Serializer;

import java.io.Serializable;

public class Main {
    public static void main(String[] args) throws Exception {
        Person person = new Person("Maksim", "Shaturko",
                                    34, true, "IT");

        Serializer serializer = new Serializer();

        serializer.writeJson("D:/projectsJWD/serializing-json" +
                "/person.json", person);

    }
}
