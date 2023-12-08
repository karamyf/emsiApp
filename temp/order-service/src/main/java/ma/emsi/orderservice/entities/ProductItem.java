package ma.emsi.orderservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import ma.emsi.orderservice.model.Product;

@Entity
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    @Transient
    private Product product;
    private double price;
    private int quantity;
    private double discount;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order order;

    public double getAmount(){
        return (price * quantity) - ((price * quantity) * discount);
    }
}
