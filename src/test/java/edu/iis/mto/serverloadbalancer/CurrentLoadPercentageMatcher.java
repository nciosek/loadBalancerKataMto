package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CurrentLoadPercentageMatcher extends TypeSafeMatcher<Server> {
    private double expectedLoadPercenatge;

    public CurrentLoadPercentageMatcher(double expectedLoadPercenatge) {
        this.expectedLoadPercenatge = expectedLoadPercenatge;
    }

    protected boolean matchesSafely(Server server) {
        return expectedLoadPercenatge == server.currentLoadPercentage || Math.abs(expectedLoadPercenatge - server.currentLoadPercentage) < 0.01d;
    }

    public void describeTo(Description description) {
        description.appendText("the server load of percentage").appendValue(expectedLoadPercenatge);
    }
}
