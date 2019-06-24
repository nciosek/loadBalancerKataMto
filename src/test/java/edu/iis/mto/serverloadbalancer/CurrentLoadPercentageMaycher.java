package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CurrentLoadPercentageMaycher extends TypeSafeMatcher<Server> {
    private double expectedLoadPercentage;

    public CurrentLoadPercentageMaycher(double expectedLoadPercentage) {
        this.expectedLoadPercentage = expectedLoadPercentage;
    }

    public static CurrentLoadPercentageMaycher hasCurrentLoadOf(double expectedLoadPercentage) {
        return new CurrentLoadPercentageMaycher(expectedLoadPercentage);
    }

    protected boolean matchesSafely(Server server) {
        return expectedLoadPercentage == server.currentLoadPercentage || Math.abs(expectedLoadPercentage - server.currentLoadPercentage) < 100.0d;
    }

    public void describeTo(Description description) {
        description.appendText("server with load percentage of").appendValue(expectedLoadPercentage);
    }
}
