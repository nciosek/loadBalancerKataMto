package edu.iis.mto.serverloadbalancer;

public class ServerLoadBalancer {
    public void balance(Server[] servers, Vm[] vms) {
        for (Vm vm : vms) {
            addToLessLoadedServer(servers, vm);
        }
    }

    private void addToLessLoadedServer(Server[] servers, Vm vm) {
        Server lessLoadedServer = findLessLoadedServer(servers, vm);
        lessLoadedServer.addVm(vm);
    }

    private Server findLessLoadedServer(Server[] servers, Vm vm) {
        Server lessLoadedServer = null;
        for (Server server : servers) {
            if (server.canFit(vm)){
                lessLoadedServer = server;
            }
        }
        return lessLoadedServer;
    }
}
