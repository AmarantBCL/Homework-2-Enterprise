package com.example.quiz.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ResourceReader {
    private final ClassPathResource resource;
    @Autowired
    private LanguageHandler languageHandler;
    private List<List<String>> records;

    public ResourceReader(String filePath) {
        resource = new ClassPathResource(filePath);
    }

    @PostConstruct
    public void read() {
        records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                resource.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] units = line.split(", ");
                records.add(Arrays.asList(units));
            }
            filterRecordsByLanguage();
        } catch (IOException e) {
            throw new RuntimeException(languageHandler.getBundle().getString("readingFileException"));
        }
    }

    private void filterRecordsByLanguage() {
        records = records.stream()
                .filter(list -> list.get(0).startsWith(languageHandler.getLocale().getLanguage()))
                .collect(Collectors.toList());
    }
}
