package com.maneng.jpa.demo.frank.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author maneng
 * @date created at 2020/3/30 1:45 下午
 */
public class HelloWorldEvent extends ApplicationEvent {

    private String from;
    private String content;


    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public HelloWorldEvent(Object source, String from, String content) {
        super(source);
        this.from = from;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
