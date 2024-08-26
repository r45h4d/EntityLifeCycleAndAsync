package com.example.csp.service.concrete;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Map;
import java.io.IOException;
import java.util.Map;

@Service
@Slf4j
public class WordReplacementService {
    /**
     * Replaces text at specific bookmarks in a Word document.
     *
     * @param inputFilePath    Path to the original Word document
     * @param outputFilePath   Path to save the modified Word document
     * @param bookmarkTextMap  Map of bookmark names to replace text
     * @throws IOException     If there is an error reading or writing the file
     */
    @Async
    public void replaceTextAtBookmarks(String inputFilePath, String outputFilePath, Map<String, String> bookmarkTextMap) throws IOException {
        try (FileInputStream fis = new FileInputStream(inputFilePath);
             XWPFDocument document = new XWPFDocument(fis)) {

            for (Map.Entry<String, String> entry : bookmarkTextMap.entrySet()) {
                String bookmarkName = entry.getKey();
                String textToReplace = entry.getValue();
                replaceTextInDocument(document, bookmarkName, textToReplace);
            }

            // Save the changes to the document
            try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
                document.write(fos);
            }
        }
    }

    /**
     * Replaces text associated with a specific bookmark in the document.
     *
     * @param document        The XWPFDocument to search in
     * @param bookmarkName    The name of the bookmark to find
     * @param textToReplace   The text to replace the bookmark with
     */
    private void replaceTextInDocument(XWPFDocument document, String bookmarkName, String textToReplace) {
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            for (XWPFRun run : paragraph.getRuns()) {
                String text = run.getText(0); // Get the text from the run
                if (text != null && text.contains(bookmarkName)) {
                    // Replace the text at the bookmark
                    text = text.replace(bookmarkName, textToReplace);
                    run.setText(text, 0); // Set the updated text
                }
            }
        }
    }
}
