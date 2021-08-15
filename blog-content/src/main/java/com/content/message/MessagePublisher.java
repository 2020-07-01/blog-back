package com.content.message;


/**
 * @ClassName : PushMessage
 * @Author : yq
 * @Date: 2021-07-30
 * @Description :
 */
public interface MessagePublisher {

    void send(String exchange, String routingKey, String message);


}
