package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ServerVmsCountMatcher extends TypeSafeMatcher<Server> {
    private int expectedCountVms;

    public ServerVmsCountMatcher(int expectedCountVms) {
        this.expectedCountVms = expectedCountVms;
    }

    public static ServerVmsCountMatcher hasCountOfVm(int expectedCountVms) {
        return new ServerVmsCountMatcher(expectedCountVms);
    }

    protected boolean matchesSafely(Server server) {
        return expectedCountVms == server.countVms();
    }

    public void describeTo(Description description) {
        description.appendText("server count vms of").appendValue(expectedCountVms);
    }

    @Override
    protected void describeMismatchSafely(Server item, Description description) {
        description.appendText("server count vms of").appendValue(item.countVms());
    }
}
