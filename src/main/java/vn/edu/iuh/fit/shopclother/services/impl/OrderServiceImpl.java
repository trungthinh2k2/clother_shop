package vn.edu.iuh.fit.shopclother.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.shopclother.entity.OrderDetail;
import vn.edu.iuh.fit.shopclother.entity.Orders;
import vn.edu.iuh.fit.shopclother.entity.Product;
import vn.edu.iuh.fit.shopclother.repositoties.OrderDetailRepository;
import vn.edu.iuh.fit.shopclother.repositoties.OrdersRepository;
import vn.edu.iuh.fit.shopclother.repositoties.ProductRepository;
import vn.edu.iuh.fit.shopclother.services.OrderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Orders create(JsonNode orderData) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // Chuyển đổi JSON thành đối tượng Orders
        Orders orders = objectMapper.convertValue(orderData, Orders.class);
        ordersRepository.save(orders);

        // Chuyển đổi chi tiết đơn hàng từ JSON thành List<OrderDetail>
        TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
        List<OrderDetail> orderDetails = objectMapper.convertValue(orderData.get("orderDetailList"), type)
                .stream()
                .peek(d -> d.setOrders(orders))
                .collect(Collectors.toList());


        // Cập nhật số lượng sản phẩm
        for (OrderDetail orderDetail : orderDetails) {
            // Tìm product có trong order
            Product product = productRepository.findById(orderDetail.getProduct().getId())
                    .orElseThrow(() -> new Exception("Sản phẩm không tồn tại: " + orderDetail.getProduct().getId()));

            if (product.getQuantity() < orderDetail.getQuantity()) {
                throw new Exception("Không đủ hàng cho sản phẩm: " + product.getProductName());
            }

            product.setQuantity(product.getQuantity() - orderDetail.getQuantity());
            productRepository.save(product);
        }
        // Lưu chi tiết đơn hàng
        orderDetailRepository.saveAll(orderDetails);
        return orders;
    }


    @Override
    public Orders findById(int id) {
        return ordersRepository.findById(id).get();
    }

    @Override
    public List<Orders> findByUsername(String username) {
        return ordersRepository.findByUsername(username);
    }
}
