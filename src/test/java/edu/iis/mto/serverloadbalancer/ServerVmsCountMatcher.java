package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ServerVmsCountMatcher extends TypeSafeMatcher<Server> {
    private int expectedVmsCount;

    public ServerVmsCountMatcher(int expectedVmsCount) {
        this.expectedVmsCount = expectedVmsCount;
    }

    public static ServerVmsCountMatcher hasVmsCountOf(int expectedVmsCount) {
        return new ServerVmsCountMatcher(expectedVmsCount);
    }

    protected boolean matchesSafely(Server server) {
        return expectedVmsCount == server.countVms();
    }

    public void describeTo(Description description) {
        description.appendText("the server with vm count of").appendValue(expectedVmsCount);
    }

    @Override
    protected void describeMismatchSafely(Server item, Description description) {
        description.appendText("the server with vm count of").appendValue(item.countVms());
    }
}
