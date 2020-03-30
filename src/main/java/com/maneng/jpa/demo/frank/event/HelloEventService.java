package com.maneng.jpa.demo.frank.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author maneng
 * @date created at 2020/3/30 1:49 下午
 */
@Service
public class HelloEventService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void sayHello(String from, String content) {
        HelloWorldEvent helloWorldEvent = new HelloWorldEvent(from, from, content);
        applicationEventPublisher.publishEvent(helloWorldEvent);
    }
}
