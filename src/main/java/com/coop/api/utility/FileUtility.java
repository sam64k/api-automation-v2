package com.coop.api.utility;

import org.apache.commons.io.IOUtils;
import org.apache.commons.text.StringSubstitutor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class FileUtility {
    public static String readFile(String fileName) throws IOException {
        String fileContent=null;
        String filePath = FileUtility.class.getClassLoader().getResource(fileName).getFile();
        fileContent = Files.readString(new File(filePath).toPath(), StandardCharsets.UTF_8);
        return fileContent;
    }

    public static String resolvedPayload(String payloadTemplate, HashMap payloadParams ){

        StringSubstitutor substitute = new StringSubstitutor(payloadParams);
        return substitute.replace(payloadTemplate);
    }
}
