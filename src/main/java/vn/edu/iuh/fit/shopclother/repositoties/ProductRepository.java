package vn.edu.iuh.fit.shopclother.repositoties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.shopclother.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT p.* FROM product p INNER JOIN product_detail pd ON p.product_id = pd.product_id " +
        "INNER JOIN product_properties pp ON pd.product_properties_id = pp.product_properties_id " +
        "WHERE pp.gender = 'Male' AND pp.type = 'adults'", nativeQuery = true)
    List<Product> findMaleAdultProducts();

    @Query(value = "SELECT p.* FROM product p INNER JOIN product_detail pd ON p.product_id = pd.product_id " +
            "INNER JOIN product_properties pp ON pd.product_properties_id = pp.product_properties_id " +
            "WHERE pp.gender = 'Female' AND pp.type = 'adults'", nativeQuery = true)
    List<Product> findFemaleAdultProducts();

    @Query(value = "SELECT p.* FROM product p INNER JOIN product_detail pd ON p.product_id = pd.product_id " +
            "INNER JOIN product_properties pp ON pd.product_properties_id = pp.product_properties_id " +
            "WHERE  pp.type = 'kids'", nativeQuery = true)
    List<Product> findKidsProducts();

    @Query(value = "SELECT p.image FROM product p WHERE p.product_id = ?;", nativeQuery = true)
    String findImageByProductId(int id);

    @Query(value = "SELECT pp.color FROM product p INNER JOIN product_detail pd ON p.product_id = pd.product_id \n" +
            "INNER JOIN product_properties pp ON pd.product_properties_id = pp.product_properties_id\n" +
            "WHERE p.product_id = ?;", nativeQuery = true)
    String findColorByProductId(int id);

    @Query(value = "SELECT pp.size FROM product p INNER JOIN product_detail pd ON p.product_id = pd.product_id \n" +
            "INNER JOIN product_properties pp ON pd.product_properties_id = pp.product_properties_id\n" +
            "WHERE p.product_id = ?;", nativeQuery = true)
    String findSizeByProductId(int id);

//    @Query("SELECT p.color FROM Product p WHERE p.id = :id")
//    String findColorByProductId(@Param("id") Integer id);
}
