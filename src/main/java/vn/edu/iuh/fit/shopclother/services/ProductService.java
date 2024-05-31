package vn.edu.iuh.fit.shopclother.services;

import vn.edu.iuh.fit.shopclother.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> findAll();

    public List<Product> findMaleAdultProducts();

    public List<Product> findFemaleAdultProducts();

    public List<Product> findKidsProducts();

    Product findById(int id);

    String findImageByProductId(int id);

    String findColorByProductId(int id);

    String findSizeByProductId(int id);

    public Product createProduct(Product product);

    public void deleteProduct(int id);

    public Product updateProduct(Product product);

    void updateProductImage(int productId, String imageUrl) throws Exception;
}
