package me.elamranioussama.eventdriven.controllers;

import me.elamranioussama.eventdriven.events.PageEvent;
import org.hibernate.query.Page;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
public class PageEventController {
    private StreamBridge streamBridge;

    public PageEventController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @GetMapping("/publish")
    public PageEvent publishEvent(String name, String topic) {
        var pageEvent = new PageEvent(
                name,
                Math.random() > 0.5 ? "U1" : "U2",
                new Date(),
                10 + new Random().nextLong(1000));

        streamBridge.send(name, topic);

        return pageEvent;
    }
}
