package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

public class ServerLoadBalancer {
    public void balance(Server[] servers, Vm[] vms) {
        for (Vm vm : vms) {
            addToLessLoadedServer(servers, vm);
        }
    }

    private void addToLessLoadedServer(Server[] servers, Vm vm) {
        List<Server> capableServer = new ArrayList<Server>();
        for (Server server : servers) {
            if (server.canFit(vm)){
                capableServer.contains(server);
            }
        }

        Server lessLoadedServer = findLessLoadedServer(capableServer);
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
