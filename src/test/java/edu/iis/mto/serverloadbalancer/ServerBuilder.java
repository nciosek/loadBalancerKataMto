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
        if (initialLoad > 0) {
            int initialVmsSize = (int) (initialLoad / (double) capacity * 100.0d);
            Vm initialVm = VmBuilder.vm().ofSize(initialVmsSize).build();
            server.addVm(initialVm);
        }
        return server;
    }

    public static ServerBuilder server() {
        return new ServerBuilder();
    }

    public ServerBuilder withCurrentLoad(double initialLoad) {
        this.initialLoad = initialLoad;
        return this;
    }
}
