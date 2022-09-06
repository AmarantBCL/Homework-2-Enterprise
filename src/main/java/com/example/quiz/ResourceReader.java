package com.example.quiz;

import lombok.Getter;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class ResourceReader {
    private final ClassPathResource resource;
    private List<List<String>> records;

    public ResourceReader(String filePath) {
        resource = new ClassPathResource(filePath);
    }

    @PostConstruct
    public void read() {
        records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                resource.getInputStream()))) {
            String line = reader.readLine();
            while (line != null) {
                String[] units = line.split(", ");
                records.add(Arrays.asList(units));
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with reading data file.");
        }
    }
}
