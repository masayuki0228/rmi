package org.example.server;

import org.example.common.Condition;
import org.example.common.Log;
import org.example.common.LogAPI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;


public class Server extends UnicastRemoteObject implements LogAPI {
    protected Server() throws RemoteException {
        super();
    }

    @Override
    public Log get(Condition condition) {
        var os = condition.getOS();
        if (os == "mac") {
            return new LogImpl(os);
        }
        return new LogImpl("mac以外");
    }

    @Override
    public Log get(int i) throws RemoteException {
        return new LogImpl("log id=" + i);
    }

    public static void main(String args[]) {
        try {
            var server = new Server();
            var registry = LocateRegistry.createRegistry(1099);
            registry.bind("get", server); // localhostだと何故か失敗する

//            Naming.bind("//localhost/get", server); こちらでも可

            System.out.println("server start");
        } catch (Exception e) {
            System.err.println("Server exception: " + e);
            e.printStackTrace();
        }
    }
}
