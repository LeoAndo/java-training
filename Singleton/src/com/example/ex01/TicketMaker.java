package com.example.ex01;

public class TicketMaker {
    private int ticket = 1000;
    private static final TicketMaker ticketMaker = new TicketMaker();
    private TicketMaker() {

    }

    public static TicketMaker getInstance() {
        return ticketMaker;
    }

    public synchronized int getNextTicketNumber() {
        return ticket++;
    }
}