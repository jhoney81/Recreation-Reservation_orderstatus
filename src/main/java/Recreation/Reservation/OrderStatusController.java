package Recreation.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderStatusController {
    @Autowired
    OrderstatusRepository orderstatusRepository;

    // orderID로 orderStatuses 조회하는 API 제공
    @RequestMapping(method= RequestMethod.GET, path="/orderStatuses/orderID")
    public Orderstatus getStatusByOrderID (@RequestParam("id") String orderID){
        System.out.println("##### getStatusByOrderID Start orderID: " + orderID);

        List<Orderstatus> searchOrderStatus = orderstatusRepository.findByOrderId(Long.valueOf(orderID));

        return searchOrderStatus.get(0);
    }
}
