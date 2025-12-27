package me.elamranioussama.eventdriven.handlers;

import me.elamranioussama.eventdriven.events.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Component
public class PageEventHandler {
    @Bean
    public Consumer<PageEvent> pageEventConsumer() {
        return (input) -> {
            System.out.println("_________________________________");
            System.out.println(input.toString());
            System.out.println("_________________________________");
        };
    }

    @Bean
    public Supplier<PageEvent> pageEventSupplier() {
        return () ->
                new PageEvent(
                        Math.random() > 0.5 ? "P1" : "P2",
                        Math.random() > 0.5 ? "U1" : "U2",
                        new Date(),
                        10 + new Random().nextLong(10000)
                );
    }
}
