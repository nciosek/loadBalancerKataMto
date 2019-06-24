package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CurrentLoadPercentageMatcher extends TypeSafeMatcher<Server> {
    private double expectedLoadPercentage;
    private static final double EPSILON = 0.01d;

    public CurrentLoadPercentageMatcher(double expectedLoadPercentage) {
        this.expectedLoadPercentage = expectedLoadPercentage;
    }

    public static CurrentLoadPercentageMatcher hasCurrentLoadOf(double expectedLoadPercentage) {
        return new CurrentLoadPercentageMatcher(expectedLoadPercentage);
    }

    protected boolean matchesSafely(Server server) {
        return doublesAreEqual(expectedLoadPercentage, server.currentLoadPercentage);
    }

    private boolean doublesAreEqual(double d1, double d2) {
        return d1 == d2 || Math.abs(d1 - d2) < EPSILON;
    }

    public void describeTo(Description description) {
        description.appendText("the server load of percentage").appendValue(expectedLoadPercentage);
    }

    @Override
    protected void describeMismatchSafely(Server item, Description description) {
        description.appendText("the server load of percentage").appendValue(item.currentLoadPercentage);
    }
}
