package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ServerVmsCountMatcher extends TypeSafeMatcher<Server> {
    private int expectedCountVm;

    public ServerVmsCountMatcher(int expectedCountVm) {
        this.expectedCountVm = expectedCountVm;
    }

    protected boolean matchesSafely(Server server) {
        return expectedCountVm == server.countVms();
    }

    public void describeTo(Description description) {
        description.appendText("the server with vms count of").appendValue(expectedCountVm);
    }

    @Override
    protected void describeMismatchSafely(Server item, Description description) {
        description.appendText("the server with vms count of").appendValue(item.countVms());
    }
}
