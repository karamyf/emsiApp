package ma.emsi.orderservice.web;

import lombok.AllArgsConstructor;
import ma.emsi.orderservice.entities.Order;
import ma.emsi.orderservice.model.Customer;
import ma.emsi.orderservice.model.Product;
import ma.emsi.orderservice.repository.OrderRepository;
import ma.emsi.orderservice.repository.ProductItemRepository;
import ma.emsi.orderservice.services.CustomerRestClientService;
import ma.emsi.orderservice.services.InventoryRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderRestController {
    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;

    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id){
        Order order = orderRepository.findById(id).get();
        Customer customer = customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItems().forEach(pi -> {
            Product product = inventoryRestClientService.productById(pi.getProductId());
            pi.setProduct(product);
        });
        return order;
    }
}
