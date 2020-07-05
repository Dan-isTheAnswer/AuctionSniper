package com.dan.auctionsniper;

import java.util.concurrent.ArrayBlockingQueue;

public class SingleMessageListener implements MessageListener {
    private final ArrayBlockQueue<Message> messages = 
                        new ArrayBlockingQueue<>(1);

    public void processMessage(Chat chat, Message message) {
        messages.add(message);
    }

    public void receivesAMessage() throws InterruptedException {
        assertThat("Message", messages.poll(5, SECONDS), is(notNullValue()));
    }
}