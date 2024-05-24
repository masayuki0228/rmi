package org.example.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LogAPI extends Remote {
    Log get(Condition condition) throws RemoteException;

    Log get(int id) throws RemoteException;
}
