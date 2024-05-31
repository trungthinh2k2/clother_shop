package vn.edu.iuh.fit.shopclother.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import vn.edu.iuh.fit.shopclother.services.UploadS3Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadS3ServiceImpl implements UploadS3Service {

    @Value("${aws.s3.bucket.name}")
    private String bucketName;

    private final S3Client s3Client;

    public UploadS3ServiceImpl(@Value("${aws.access.key.id}") String accessKeyId,
                               @Value("${aws.secret.access.key}") String secretKey,
                               @Value("${aws.region}") String region) {
        AwsBasicCredentials awsCredentials = AwsBasicCredentials.create(accessKeyId, secretKey);
        this.s3Client = S3Client.builder()
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
                .region(Region.of(region))
                .build();
    }
//    @Override
//    public String uploadFile(MultipartFile file) {
//        try {
//            String key = Paths.get(file.getOriginalFilename()).getFileName().toString();
//            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
//                    .bucket(bucketName)
//                    .key(key)
//                    .build();
//            s3Client.putObject(putObjectRequest, (Path) file.getInputStream());
//            return "https://" + bucketName + ".s3.amazonaws.com/" + key;
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to upload file to S3", e);
//        }
//    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        String key = file.getOriginalFilename(); // Sử dụng tên gốc của tệp làm "key"
        Path tempFile = Files.createTempFile("temp", null); // Tạo tệp tạm thời
        file.transferTo(tempFile); // Chuyển dữ liệu từ MultipartFile vào tệp tạm thời

        // Xác định yêu cầu PutObject
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        // Tải tệp tạm thời lên S3
        s3Client.putObject(putObjectRequest, RequestBody.fromFile(tempFile));

        // Xóa tệp tạm thời sau khi tải lên thành công
        Files.delete(tempFile);

        return key; // Trả về "key" của tệp đã tải lên
    }
}
