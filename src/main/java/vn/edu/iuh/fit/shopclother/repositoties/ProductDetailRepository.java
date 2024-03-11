package vn.edu.iuh.fit.shopclother.repositoties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.shopclother.entity.ProductDetail;
@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {
}