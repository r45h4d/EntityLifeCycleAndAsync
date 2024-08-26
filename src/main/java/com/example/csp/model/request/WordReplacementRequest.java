package com.example.csp.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordReplacementRequest {
    private String inputFilePath;
    private String outputFilePath;
    private Map<String, String> bookmarkTextMap;
}
