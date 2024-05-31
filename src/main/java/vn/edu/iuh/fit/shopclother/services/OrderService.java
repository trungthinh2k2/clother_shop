package vn.edu.iuh.fit.shopclother.services;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import vn.edu.iuh.fit.shopclother.entity.Orders;
import vn.edu.iuh.fit.shopclother.repositoties.OrdersRepository;

import java.util.List;

public interface OrderService {

    public Orders create(JsonNode jsonNode) throws Exception;

    public Orders findById(int id);

    public List<Orders> findByUsername(String username);
}
