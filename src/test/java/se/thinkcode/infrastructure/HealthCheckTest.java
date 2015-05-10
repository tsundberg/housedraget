package se.thinkcode.infrastructure;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HealthCheckTest {
    @Test
    public void shouldReturnHealthCheck() throws Exception {
        HealthCheck healthCheck = new HealthCheck();

        HealthCheck.Result actual = healthCheck.check();

        assertTrue("Should return a health check", actual != null);
    }
}
