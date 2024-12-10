
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Autowired
public JmsOrderMessagingService(JmsTemplate jms) {
this.jms = jms;
}
@Override
public void sendOrder(Order order) {
jms.send(new MessageCreator() {
@Override
public Message createMessage(Session session)
throws JMSException {
return session.createObjectMessage(order);
}
}
);
}

@Override
public void sendOrder(Order order) {
jms.send(session -> session.createObjectMessage(order));
}

@Bean
public Destination orderQueue() {
return new ActiveMQQueue("tacocloud.order.queue");
}


private Destination orderQueue;
@Autowired
public JmsOrderMessagingService(JmsTemplate jms,
Destination orderQueue) {
this.jms = jms;
this.orderQueue = orderQueue;
}


@Override
public void sendOrder(Order order) {
jms.send(
orderQueue,
session -> session.createObjectMessage(order));
}

@Override
public void sendOrder(Order order) {
jms.send(
"tacocloud.order.queue",
session -> session.createObjectMessage(order));
}


@Override
public void sendOrder(Order order) {
jms.convertAndSend("tacocloud.order.queue", order);
}

public interface MessageConverter {
Message toMessage(Object object, Session session)
throws JMSException, MessageConversionException;
Object fromMessage(Message message)
}