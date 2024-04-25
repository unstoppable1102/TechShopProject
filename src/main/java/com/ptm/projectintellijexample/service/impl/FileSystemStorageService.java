package com.ptm.projectintellijexample.service.impl;

import com.ptm.projectintellijexample.service.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileSystemStorageService implements StorageService {

    private final Path rootLocation;

    public FileSystemStorageService() {
        this.rootLocation = Paths.get("src/main/resources/static/uploads");
    }

    @Override
    public void store(MultipartFile file) {
        try {
            // Kiểm tra xem file có phải là ảnh không
            if (!isImage(file)) {
                throw new IllegalArgumentException("Only images are allowed.");
            }

            Path destinationFile = this.rootLocation.resolve(
                    Paths.get(Objects.requireNonNull(file.getOriginalFilename()))
                            .normalize().toAbsolutePath());
            try (InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }catch (IOException e){
           throw new RuntimeException(e);
        }
    }

    @Override
    public void init() {
        if (!Files.exists(rootLocation)) {
            try {
                Files.createDirectories(rootLocation);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
    // Phương thức để kiểm tra xem file có phải là ảnh không
    private boolean isImage(MultipartFile file) {
        String contentType = file.getContentType();
        return contentType != null && contentType.startsWith("image");
    }
}
