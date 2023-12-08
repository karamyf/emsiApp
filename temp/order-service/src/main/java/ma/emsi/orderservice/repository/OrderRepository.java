package ma.emsi.orderservice.repository;

import feign.Param;
import ma.emsi.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long>{
    @RestResource(path = "/byCustomer")
    List<Order> findByCustomerId(@Param("customerId") Long customerId);
}
