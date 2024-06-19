package com.job.portal.web.application.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @Created 19/6/2024 - 7:53 PM on (Wednesday)
 * @Package com.job.portal.web.application.util
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public class FileUploadUtil {
    public static void saveFile(String uploadDir, String filename, MultipartFile multipartFile) throws IOException {

        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream();) {
            Path path = uploadPath.resolve(filename);
            System.out.println("FilePath " + path);
            System.out.println("fileName " + filename);
            Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + filename, ioe);

        }
    }
}
