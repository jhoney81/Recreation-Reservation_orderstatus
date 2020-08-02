package Recreation.Reservation;

import Recreation.Reservation.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderstatusViewHandler {


    @Autowired
    private OrderstatusRepository orderstatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomOrdered_then_CREATE_1 (@Payload RoomOrdered roomOrdered) {
        try {
            if (roomOrdered.isMe()) {
                // view 객체 생성
                Orderstatus orderstatus = new Orderstatus();
                // view 객체에 이벤트의 Value 를 set 함
                orderstatus.setOrderId(roomOrdered.getId());
                orderstatus.setOrderDate(roomOrdered.getOrderDate());
                orderstatus.setRoomId(roomOrdered.getRoomId());
                orderstatus.setRoomName(roomOrdered.getRoomName());
                orderstatus.setCustomerId(roomOrdered.getCustomerId());

                // view 레파지 토리에 save
                orderstatusRepository.save(orderstatus);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationAccepted_then_UPDATE_1(@Payload ReservationAccepted reservationAccepted) {
        try {
            if (reservationAccepted.isMe()) {
                // view 객체 조회
                List<Orderstatus> orderstatusList = orderstatusRepository.findByOrderId(reservationAccepted.getOrderId());
                for(Orderstatus orderstatus : orderstatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderstatus.setAgentName(reservationAccepted.getAgentName());
                    orderstatus.setReservationDate(reservationAccepted.getReservationDate());
                    orderstatus.setStatus(reservationAccepted.getStatus());
                    // view 레파지 토리에 save
                    orderstatusRepository.save(orderstatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCompleted_then_UPDATE_2(@Payload ReservationCompleted reservationCompleted) {
        try {
            if (reservationCompleted.isMe()) {
                // view 객체 조회
                List<Orderstatus> orderstatusList = orderstatusRepository.findByOrderId(reservationCompleted.getOrderId());
                for(Orderstatus orderstatus : orderstatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderstatus.setStatus(reservationCompleted.getStatus());
                    orderstatus.setReservationDate(reservationCompleted.getReservationDate());
                    // view 레파지 토리에 save
                    orderstatusRepository.save(orderstatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomCompleted_then_UPDATE_3(@Payload RoomCompleted roomCompleted) {
        try {
            if (roomCompleted.isMe()) {
                // view 객체 조회
                List<Orderstatus> orderstatusList = orderstatusRepository.findByOrderId(roomCompleted.getOrderId());
                for(Orderstatus orderstatus : orderstatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderstatus.setStatus(roomCompleted.getStatus());
                    // view 레파지 토리에 save
                    orderstatusRepository.save(orderstatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCancelOrdered_then_UPDATE_4(@Payload CancelOrdered cancelOrdered) {
        try {
            if (cancelOrdered.isMe()) {
                // view 객체 조회
                List<Orderstatus> orderstatusList = orderstatusRepository.findByOrderId(cancelOrdered.getId());
                for(Orderstatus orderstatus : orderstatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderstatus.setStatus(cancelOrdered.getStatus());
                    // view 레파지 토리에 save
                    orderstatusRepository.save(orderstatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCancelAccepted_then_UPDATE_5(@Payload OrderCancelAccepted orderCancelAccepted) {
        try {
            if (orderCancelAccepted.isMe()) {
                // view 객체 조회
                List<Orderstatus> orderstatusList = orderstatusRepository.findByOrderId(orderCancelAccepted.getOrderId());
                for(Orderstatus orderstatus : orderstatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderstatus.setStatus(orderCancelAccepted.getStatus());
                    // view 레파지 토리에 save
                    orderstatusRepository.save(orderstatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCanceled_then_UPDATE_6(@Payload ReservationCanceled reservationCanceled) {
        try {
            if (reservationCanceled.isMe()) {
                // view 객체 조회
                List<Orderstatus> orderstatusList = orderstatusRepository.findByOrderId(reservationCanceled.getOrderId());
                for(Orderstatus orderstatus : orderstatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderstatus.setStatus(reservationCanceled.getStatus());
                    // view 레파지 토리에 save
                    orderstatusRepository.save(orderstatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_7(@Payload OrderCanceled orderCanceled) {
        try {
            if (orderCanceled.isMe()) {
                // view 객체 조회
                List<Orderstatus> orderstatusList = orderstatusRepository.findByOrderId(orderCanceled.getId());
                for(Orderstatus orderstatus : orderstatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderstatus.setStatus(orderCanceled.getStatus());
                    // view 레파지 토리에 save
                    orderstatusRepository.save(orderstatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomOrderCompleted_then_UPDATE_8(@Payload RoomOrderCompleted roomOrderCompleted) {
        try {
            if (roomOrderCompleted.isMe()) {
                // view 객체 조회
                List<Orderstatus> orderstatusList = orderstatusRepository.findByOrderId(roomOrderCompleted.getId());
                for(Orderstatus orderstatus : orderstatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderstatus.setStatus(roomOrderCompleted.getStatus());
                    // view 레파지 토리에 save
                    orderstatusRepository.save(orderstatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}