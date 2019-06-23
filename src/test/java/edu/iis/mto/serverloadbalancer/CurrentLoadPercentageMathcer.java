package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CurrentLoadPercentageMathcer extends TypeSafeMatcher<Server> {
    private double expectedLoadPercentage;
    private static final double EPSILON = 0.01d;

    public CurrentLoadPercentageMathcer(double expectedLoadPercentage) {
        this.expectedLoadPercentage = expectedLoadPercentage;
    }

    public static CurrentLoadPercentageMathcer hasCurrentLoadOf(double expectedLoadPercentage) {
        return new CurrentLoadPercentageMathcer(expectedLoadPercentage);
    }

    protected boolean matchesSafely(Server server) {
        return expectedLoadPercentage == server.currentLoadPercentage || Math.abs(expectedLoadPercentage - server.currentLoadPercentage) < EPSILON;
    }

    public void describeTo(Description description) {
        description.appendText("server with vms load of ").appendValue(expectedLoadPercentage);
    }

    @Override
    protected void describeMismatchSafely(Server item, Description description) {
        description.appendText("server with vms load of ").appendValue(item.currentLoadPercentage);
    }
}
