// Send raw messages
void send(Message message) throws AmqpException;
void send(String routingKey, Message message) throws AmqpException;
void send(String exchange, String routingKey, Message message)
throws AmqpException;
// Send messages converted from objects
void convertAndSend(Object message) throws AmqpException;
void convertAndSend(String routingKey, Object message)
throws AmqpException;
void convertAndSend(String exchange, String routingKey,
Object message) throws AmqpException;
// Send messages converted from objects with post-processing
void convertAndSend(Object message, MessagePostProcessor mPP)
throws AmqpException;
void convertAndSend(String routingKey, Object message,
MessagePostProcessor messagePostProcessor)
throws AmqpException;
void convertAndSend(String exchange, String routingKey,
Object message,
MessagePostProcessor messagePostProcessor)
throws AmqpException;