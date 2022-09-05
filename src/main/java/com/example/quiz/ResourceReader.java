package com.example.quiz;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class ResourceReader {
    @Setter
    private ClassPathResource resource;
    private List<List<String>> records;

    @SneakyThrows
    public void read() {
        records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                resource.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> questions = new ArrayList<>();
                String[] units = line.split(",");
                Arrays.stream(units).forEach(s -> questions.add(s.trim()));
                records.add(questions);
            }
        }
    }
}
