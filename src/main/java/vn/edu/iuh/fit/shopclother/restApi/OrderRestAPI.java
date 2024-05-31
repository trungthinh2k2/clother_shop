package vn.edu.iuh.fit.shopclother.restApi;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.shopclother.entity.Orders;
import vn.edu.iuh.fit.shopclother.services.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/order")
public class OrderRestAPI {

    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public Orders create(@RequestBody JsonNode orderData) throws Exception {
        return orderService.create(orderData);
    }

}
