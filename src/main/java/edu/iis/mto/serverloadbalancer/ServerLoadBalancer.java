package edu.iis.mto.serverloadbalancer;

public class ServerLoadBalancer {
    public void balance(Server[] servers, Vm[] vms) {
        for (Vm vm : vms) {
            Server lessLoadedServer = null;
            for (Server server : servers) {
                if (server.canFit(vm)){
                    lessLoadedServer = server;
                }
            }
            lessLoadedServer.addVm(vm);
        }

    }
}
