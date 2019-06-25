package edu.iis.mto.serverloadbalancer;

public class Server {

    private static final double MAXIMUM_LOAD = 100.0d;
    public double currentLoadPercentage;
    public int capacity;

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public boolean contains(Vm theVm) {
        return true;
    }

    public void addVm(Vm vm) {
        currentLoadPercentage = (double) vm.size / (double)capacity * MAXIMUM_LOAD;
    }

    public int countVms() {
        return 0;
    }
}
