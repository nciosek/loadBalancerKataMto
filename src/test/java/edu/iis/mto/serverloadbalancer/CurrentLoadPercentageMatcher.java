package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class CurrentLoadPercentageMatcher extends TypeSafeMatcher<Server> {
    private double expectedLoadPercenatge;
    public static final double EPSILON = 0.01d;

    public CurrentLoadPercentageMatcher(double expectedLoadPercenatge) {
        this.expectedLoadPercenatge = expectedLoadPercenatge;
    }

    public static CurrentLoadPercentageMatcher hasCurrentLoadOf(double expectedLoadPercenatge) {
        return new CurrentLoadPercentageMatcher(expectedLoadPercenatge);
    }

    protected boolean matchesSafely(Server server) {
        return doublesAreEqual(expectedLoadPercenatge, server.currentLoadPercentage);
    }

    private boolean doublesAreEqual(double d1, double d2) {
        return d1 == d2 || Math.abs(d1 - d2) < EPSILON;
    }

    public void describeTo(Description description) {
        description.appendText("the server load percentage of").appendValue(expectedLoadPercenatge);
    }

    @Override
    protected void describeMismatchSafely(Server item, Description description) {
        description.appendText("the server load percentage of").appendValue(item.currentLoadPercentage);
    }
}
