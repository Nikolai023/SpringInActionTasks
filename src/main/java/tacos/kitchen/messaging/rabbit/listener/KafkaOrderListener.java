package tacos.kitchen.messaging.rabbit.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tacos.Order;
import tacos.kitchen.KitchenUI;

@Component
public class KafkaOrderListener {
    private KitchenUI ui;

    public KafkaOrderListener(KitchenUI ui) {
        this.ui = ui;
    }

    @KafkaListener(topics = "tacocloud.orders.topic")
    public void handle(Order order) {
        ui.displayOrder(order);
    }
}
