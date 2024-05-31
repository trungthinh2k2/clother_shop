package vn.edu.iuh.fit.shopclother.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadS3Service {
    String uploadFile(MultipartFile file) throws IOException;
}
