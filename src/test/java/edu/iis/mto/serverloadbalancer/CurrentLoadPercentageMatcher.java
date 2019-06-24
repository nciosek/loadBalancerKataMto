package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CurrentLoadPercentageMatcher extends TypeSafeMatcher<Server> {
    private double expectedLoadPercentage;

    public CurrentLoadPercentageMatcher(double expectedLoadPercentage) {
        this.expectedLoadPercentage = expectedLoadPercentage;
    }

    public static CurrentLoadPercentageMatcher hasCurrentLoadOf(double expectedLoadPercentage) {
        return new CurrentLoadPercentageMatcher(expectedLoadPercentage);
    }

    protected boolean matchesSafely(Server server) {
        return expectedLoadPercentage == server.hasCurrentPercentage || Math.abs(expectedLoadPercentage - server.hasCurrentPercentage) < 0.01d;
    }

    public void describeTo(Description description) {
        description.appendText("server with vms load of percentage").appendValue(expectedLoadPercentage);
    }

    @Override
    protected void describeMismatchSafely(Server item, Description description) {
        description.appendText("server with vms load of percentage").appendValue(item.hasCurrentPercentage);
    }
}
