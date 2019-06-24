package edu.iis.mto.serverloadbalancer;

public class Server {
    public double hasCurrentPercentage;
    public int capacity;
    private static final double MAXIMUM_LOAD = 100.0d;

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public boolean contains(Vm theVm) {
        return true;
    }

    public void addVm(Vm vm) {
        hasCurrentPercentage = (double)vm.size / (double)capacity * MAXIMUM_LOAD;
    }
}
