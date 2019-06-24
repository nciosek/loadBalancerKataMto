package edu.iis.mto.serverloadbalancer;

public class ServerLoadBalancer {
    public void balance(Server[] servers, Vm[] vms) {
        for (Vm vm : vms) {
            servers[0].hasCurrentPercentage = (double)vms[0].size / (double)servers[0].capacity * 100.0d;
        }

    }
}
