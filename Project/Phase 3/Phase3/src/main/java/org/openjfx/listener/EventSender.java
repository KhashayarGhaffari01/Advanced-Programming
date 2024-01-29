package org.openjfx.listener;

import events.Event;
import responses.Response;

public interface EventSender {
    Response send(Event event);

    void close();

}
