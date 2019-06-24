package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;


public class ServerVmsCountOfMatcher extends TypeSafeMatcher<Server> {
    private int expectedVmsCount;

    public ServerVmsCountOfMatcher(int expectedVmsCount) {
        this.expectedVmsCount = expectedVmsCount;
    }

    public static ServerVmsCountOfMatcher hasAVmsCountOf(int expectedVmsCount) {
        return new ServerVmsCountOfMatcher(expectedVmsCount);
    }

    protected boolean matchesSafely(Server server) {
        return expectedVmsCount == server.countVms();
    }

    public void describeTo(Description description) {
        description.appendText("the server with vms count of").appendValue(expectedVmsCount);
    }

    @Override
    protected void describeMismatchSafely(Server item, Description description) {
        description.appendText("the server with vms count of").appendValue(item.countVms());
    }
}
