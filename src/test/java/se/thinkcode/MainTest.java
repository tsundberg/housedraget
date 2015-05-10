package se.thinkcode;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;

public class MainTest {
    @Test
    public void shouldGetApplicationName() {
        String expected = "housedraget";
        Main main = new Main();

        String actual = main.getName();

        assertThat(actual, is(expected));
    }
}
