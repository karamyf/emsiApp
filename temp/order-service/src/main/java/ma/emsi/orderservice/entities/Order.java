package ma.emsi.orderservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.emsi.orderservice.enums.OrderStatus;
import ma.emsi.orderservice.model.Customer;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Builder
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private OrderStatus status;
    private Long customerId;
    @Transient
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;

    public double getTotalAmount(){
        double amount=0;
        for (ProductItem productItem : productItems) {
            amount+=productItem.getAmount();
        }
        return amount;
    }
}
