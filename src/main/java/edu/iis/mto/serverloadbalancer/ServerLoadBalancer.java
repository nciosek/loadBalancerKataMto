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
				capableServer.add(server);
			}
		}

		Server lessLoaded = extractLessLoadedServer(capableServer);
		if (lessLoaded != null) {
			lessLoaded.addVm(vm);
		}
	}

	private Server extractLessLoadedServer(List<Server> servers) {
		Server lessLoaded = null;
		for(Server server : servers){
			if(lessLoaded == null || lessLoaded.currentLoadPecentage > server.currentLoadPecentage){
				lessLoaded = server;
			}
		}
		return lessLoaded;
	}

}
