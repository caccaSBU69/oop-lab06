package it.unibo.exceptions;

import java.io.IOException;


public class NetworkException extends IOException {

    public NetworkException() {
        throw new IOException("Network error: no response");
    }

    public NetworkException(String s) {
        throw new IOException("Network error while sending message: <message>");
    }
}