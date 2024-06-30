//package vn.edu.iuh.fit.shopclother.restApi;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import vn.edu.iuh.fit.shopclother.services.ProductService;
//import vn.edu.iuh.fit.shopclother.services.UploadS3Service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/rest/upload")
//public class UploadRestAPI {
//   @Autowired
//    private UploadS3Service uploadS3Service;
//    @Autowired
//    private ProductService productService;
//
//    @PostMapping("/images")
//    public String uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("productId") int id) {
//        try {
//            String imageUrl = uploadS3Service.uploadFile(file); // Upload file và lấy URL của hình ảnh
//            productService.updateProductImage(id, imageUrl); // Cập nhật hình ảnh của sản phẩm
//            System.out.println("URL: " + imageUrl);
//            return imageUrl; // Trả về URL của hình ảnh
//        } catch (Exception e) {
//            throw new RuntimeException("Lỗi upload hình ảnh 2", e);
//        }
//    }
//
////    @PostMapping("/images")
////    public ResponseEntity<Map<String, String>> uploadImage(@RequestParam("file") MultipartFile file) {
////        try {
////            String imageUrl = uploadS3Service.uploadFile(file);
////            Map<String, String> response = new HashMap<>();
////            response.put("url", imageUrl);
////            return ResponseEntity.ok(response);
////        } catch (Exception e) {
////            return ResponseEntity.status(500).body(null);
////        }
////    }
//
//}