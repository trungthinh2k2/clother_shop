package vn.edu.iuh.fit.shopclother.repositoties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.shopclother.entity.OrderDetail;
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}