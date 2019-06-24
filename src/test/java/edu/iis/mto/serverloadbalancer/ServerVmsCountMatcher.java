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

    public static ServerVmsCountMatcher aVmsCount(int expectedCountVm) {
        return new ServerVmsCountMatcher(expectedCountVm);
    }

    public void describeTo(Description description) {
        description.appendText("server count vms of").appendValue(expectedCountVm);
    }

    @Override
    protected void describeMismatchSafely(Server item, Description description) {
        description.appendText("server count vms of").appendValue(item.countVms());
    }
}
