package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

public class Server {
    public double currentLoadPercentage;
    public int capacity;
    private static final double MAXIMUM_LOAD = 100.0d;

    private List<Vm> vms = new ArrayList<Vm>();

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public boolean contains(Vm theVm) {
        return vms.contains(theVm);
    }

    public void addVm(Vm vm) {
        currentLoadPercentage = loadOf(vm);
        this.vms.add(vm);
    }

    private double loadOf(Vm vm) {
        return (double) vm.size / (double) capacity * MAXIMUM_LOAD;
    }

    public int countVms() {
        return vms.size();
    }

    public boolean canFit(Vm vm) {
        return currentLoadPercentage + (loadOf(vm)) <= MAXIMUM_LOAD;
    }
}
