package org.example.client;

import org.example.common.LogAPI;

import java.rmi.Naming;

public class Client {
    private Client() {}

    public static void main(String[] args) {

        try {
            LogAPI stub = (LogAPI) Naming.lookup("//:/get");
            var response = stub.get(100);
            response.print();
        } catch (Exception e) {
            System.err.println("Client exception: " + e);
            e.printStackTrace();
        }
    }
}