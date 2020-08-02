package Recreation.Reservation;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderstatusRepository extends CrudRepository<Orderstatus, Long> {

    List<Orderstatus> findByOrderId(Long orderId);

}