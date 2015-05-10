package se.thinkcode.infrastructure;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class ConfigurationTest {
    @Test
    public void shouldCreateConfigs(){
        Configuration configuration = new Configuration();

        assertNotNull("Should be able to create an empty configuration", configuration);
    }
}
