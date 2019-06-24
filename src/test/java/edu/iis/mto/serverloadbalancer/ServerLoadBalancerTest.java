package edu.iis.mto.serverloadbalancer;


import static edu.iis.mto.serverloadbalancer.CurrentLoadPercentageMaycher.hasCurrentLoadOf;
import static edu.iis.mto.serverloadbalancer.ServerBuilder.server;
import static edu.iis.mto.serverloadbalancer.ServerVmsCountMatcher.aVmsCountOf;
import static edu.iis.mto.serverloadbalancer.VmBuilder.vm;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matcher;
import org.junit.Test;

public class ServerLoadBalancerTest {
	@Test
	public void itCompiles() {
		assertThat(true, equalTo(true));
	}

	@Test
    public void test1(){
	    Server theServer = a(server().withCapacity(1));

	    balancing(aServersListWith(theServer), anEmptyVmsList());

	    assertThat(theServer, hasCurrentLoadOf(0.0d));
    }

    @Test
	public void test2(){
		Server theServer = a(server().withCapacity(1));
		Vm theVm = a(vm().ofSize(1));
		balancing(aServersListWith(theServer), aVmsListWith(theVm));

		assertThat(theServer, hasCurrentLoadOf(100.0d));
		assertThat("the server should conatin the vm", theServer.contains(theVm));
	}

	@Test
	public void test3(){
		Server theServer = a(server().withCapacity(10));
		Vm theVm = a(vm().ofSize(1));
		balancing(aServersListWith(theServer), aVmsListWith(theVm));

		assertThat(theServer, hasCurrentLoadOf(10.0d));
		assertThat("the server should conatin the vm", theServer.contains(theVm));
	}

	@Test
	public void test4(){
		Server theServer = a(server().withCapacity(100));
		Vm theFirstVm = a(vm().ofSize(1));
		Vm theSecondVm = a(vm().ofSize(1));
		balancing(aServersListWith(theServer), aVmsListWith(theFirstVm, theSecondVm));

		assertThat(theServer, aVmsCountOf(2));
		assertThat("the server should conatin the first vm", theServer.contains(theFirstVm));
		assertThat("the server should conatin the second vm", theServer.contains(theSecondVm));
	}

	@Test
	public void test5(){
		Server moreLoadedServer = a(server().withCapacity(100).withCurrentLoad(50.0d));
		Server lessLoadedServer = a(server().withCapacity(100).withCurrentLoad(45.0d));
		Vm theVm = a(vm().ofSize(10));
		balancing(aServersListWith(moreLoadedServer, lessLoadedServer), aVmsListWith(theVm));

		assertThat("the less loaded server should conatin the vm", lessLoadedServer.contains(theVm));
		assertThat("the more loaded server should not conatin the vm", !moreLoadedServer.contains(theVm));
	}

	@Test
	public void test6(){
		Server theServer = a(server().withCapacity(10).withCurrentLoad(90.0d));
		Vm theVm = a(vm().ofSize(2));
		balancing(aServersListWith(theServer), aVmsListWith(theVm));

		assertThat("the server should not conatin the vm", theServer.contains(theVm));
	}

	private Vm[] aVmsListWith(Vm... vms) {
		return vms;
	}

	private void balancing(Server[] servers, Vm[] vms) {
		new ServerLoadBalancer().balance(servers, vms);
	}

	private Vm[] anEmptyVmsList() {
		return new Vm[0];
	}

	private Server[] aServersListWith(Server... servers) {
		return servers;
	}

	private <T> T a(Builder<T> builder){
		return builder.build();
	}
}
