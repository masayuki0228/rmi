package org.example.server;

import org.example.common.Log;

public class LogImpl implements Log {
    private String os;

    public LogImpl(String os) {
        this.os = os;
    }

    @Override
    public void print() {
        System.out.println(os + "のログです");
    }
}
