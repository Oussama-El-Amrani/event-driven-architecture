package me.elamranioussama.eventdriven.events;

import java.util.Date;

public record PageEvent (String name, String userName, Date date, Long duration){
}
