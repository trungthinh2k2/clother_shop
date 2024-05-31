package vn.edu.iuh.fit.shopclother.repositoties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.shopclother.entity.Orders;
import vn.edu.iuh.fit.shopclother.entity.Product;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    @Query(value = "select o.* from orders o inner join account a on o.user_name = a.user_name \n" +
            "where a.user_name = ?", nativeQuery = true)
    List<Orders> findByUsername(String username);
}