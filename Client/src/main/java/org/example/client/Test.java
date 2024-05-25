package org.example.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) {
        String fileName = "/Users/hirosawamasayuki/IdeaProjects/RMI/Client/src/main/java/org/example/client/foo.txt";
        try {
            var line = Files.readString(Paths.get(fileName));
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
