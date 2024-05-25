package org.example.client;

import org.example.common.LogAPI;

import java.rmi.registry.LocateRegistry;

// Serverをimplementationしていないため失敗する
// しかし、以下の記述で成功はする
// java -cp Server.jar:Client.jar org.example.client.Client
public class Client {
    private Client() {}

    public static void main(String[] args) {

        try {
            var registry = LocateRegistry.getRegistry();
            var stub = (LogAPI) registry.lookup("get");

//            LogAPI stub = (LogAPI) Naming.lookup("//:/get"); こちらでも可

            var response = stub.get(100);
            response.print();
        } catch (Exception e) {
            System.err.println("Client exception: " + e);
            e.printStackTrace();
        }
    }
}