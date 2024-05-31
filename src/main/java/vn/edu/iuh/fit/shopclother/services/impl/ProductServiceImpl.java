package vn.edu.iuh.fit.shopclother.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.shopclother.entity.Product;
import vn.edu.iuh.fit.shopclother.repositoties.ProductRepository;
import vn.edu.iuh.fit.shopclother.services.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findMaleAdultProducts() {
        return productRepository.findMaleAdultProducts();
    }

    @Override
    public List<Product> findFemaleAdultProducts() {
        return productRepository.findFemaleAdultProducts();
    }

    @Override
    public List<Product> findKidsProducts() {
        return productRepository.findKidsProducts();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public String findImageByProductId(int id) {
        return productRepository.findImageByProductId(id);
    }

    @Override
    public String findColorByProductId(int id) {
        return productRepository.findColorByProductId(id);
    }

    @Override
    public String findSizeByProductId(int id) {
        return productRepository.findSizeByProductId(id);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void updateProductImage(int productId, String imageUrl) throws Exception {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new Exception("Sản phẩm không tồn tại: " + productId));
        product.setImage(imageUrl);
        productRepository.save(product);
    }




}
