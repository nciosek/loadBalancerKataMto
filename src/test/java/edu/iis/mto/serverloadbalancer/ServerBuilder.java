package edu.iis.mto.serverloadbalancer;

public class ServerBuilder implements Builder<Server> {
    private int capacity;
    private double initialLoad;

    public ServerBuilder withCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public Server build() {
        final Server server = new Server(capacity);
        findInitialLoad(server);
        return server;
    }

    private void findInitialLoad(Server server) {
        if (initialLoad > 0) {
            int initialVmsSize = (int) (initialLoad / (double) capacity * server.MAXIMUM_LOAD);
            Vm initialVms = VmBuilder.vm().ofSize(initialVmsSize).build();
            server.addVm(initialVms);
        }
    }

    public static ServerBuilder server() {
        return new ServerBuilder();
    }

    public ServerBuilder withCurrentLoad(double initialLoad) {
        this.initialLoad = initialLoad;
        return this;
    }
}
