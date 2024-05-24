package org.example.server;

import org.example.common.Condition;
import org.example.common.Log;
import org.example.common.LogAPI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Server implements LogAPI {
    public Server() {
    }

    @Override
    public Log get(Condition condition) throws RemoteException {
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
            Server server = new Server();
            LogAPI stub = (LogAPI) UnicastRemoteObject.exportObject(server, 0);
            LocateRegistry.createRegistry(1099);
            Naming.rebind("//localhost/get", stub);

            System.out.println("server start");
        } catch (Exception e) {
            System.err.println("Server exception: " + e);
            e.printStackTrace();
        }
    }
}
