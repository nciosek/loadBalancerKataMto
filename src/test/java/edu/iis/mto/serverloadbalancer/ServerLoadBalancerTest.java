package edu.iis.mto.serverloadbalancer;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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


}
