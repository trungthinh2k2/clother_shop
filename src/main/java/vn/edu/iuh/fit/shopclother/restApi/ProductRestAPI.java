package vn.edu.iuh.fit.shopclother.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.shopclother.entity.Product;
import vn.edu.iuh.fit.shopclother.services.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/product")
public class ProductRestAPI {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public Product getOne(@PathVariable("id") int id) {
        return productService.findById(id);
    }

    @GetMapping("/list")
    public List<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<Map<String, String>> getImageByProductId(@PathVariable int id) {
        String image = String.valueOf(productService.findImageByProductId(id));
        Map<String, String> response = new HashMap<>();
        response.put("image", image);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/color")
    public ResponseEntity<Map<String, String>> getColorByProductId(@PathVariable int id) {
        String color = String.valueOf(productService.findColorByProductId(id));
        Map<String, String> response = new HashMap<>();
        response.put("color", color);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}/size")
    public ResponseEntity<Map<String, String>> getSizeByProductId(@PathVariable int id) {
        String size = String.valueOf(productService.findSizeByProductId(id));
        Map<String, String> response = new HashMap<>();
        response.put("size", size);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(product);
    }
    @PostMapping("/update")
    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
        try {
            productService.updateProduct(product);
            return ResponseEntity.ok("Product updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating product");
        }
    }

}


