package com.maneng.jpa.demo.frank.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author maneng
 * @date created at 2020/3/30 1:48 下午
 */
@Component
public class HelloEventListen {

    @EventListener
    public void processHelloWorldEvent(HelloWorldEvent helloWorldEvent) {
        System.out.println(helloWorldEvent.getFrom() + ": " + helloWorldEvent.getContent());
    }
}
