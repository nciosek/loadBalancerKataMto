package edu.iis.mto.serverloadbalancer;

public class Server {
    public double hasCurrentPercentage;
    public int capacity;

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public boolean contains(Vm theVm) {
        return true;
    }
}
