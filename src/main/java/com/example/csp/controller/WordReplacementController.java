package com.example.csp.controller;

import java.io.IOException;
import java.util.Map;

import com.example.csp.model.request.WordReplacementRequest;
import com.example.csp.service.concrete.WordReplacementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class WordReplacementController {

    private final WordReplacementService wordReplacementService;

    @PostMapping("/replace")
    public String replaceWords(@RequestBody WordReplacementRequest request) {
        try {
            wordReplacementService.replaceTextAtBookmarks(
                    request.getInputFilePath(),
                    request.getOutputFilePath(),
                    request.getBookmarkTextMap()
            );
            return "Replacement successful!";
        } catch (IOException e) {
            //e.printStackTrace();
            return "Error during replacement: " + e.getMessage();
        }
    }
}
