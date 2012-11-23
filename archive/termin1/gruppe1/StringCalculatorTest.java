import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.assertEquals;

public class StringCalculatorTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private StringCalculator stringCalculator;

    @Before
    public void setUp() throws Exception {
        stringCalculator = new StringCalculator();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void dotSeparatedNumbersShouldGetSum() {
        assertEquals(4, stringCalculator.add("2.2"));
    }

    @Test
    public void emptyStringShouldGetZero() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void newLineShouldBeDelimiter() throws Exception {
        assertEquals(4, stringCalculator.add("2\n2"));
    }

    @Test
    public void multipleAddShouldGetAccumulatedSum() throws Exception {
        stringCalculator.add("1");
        assertEquals(2, stringCalculator.add("1"));
    }

    @Test
    public void negativeNumberNotAllowed() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Negative numbers not allowed!");
        stringCalculator.add("-1.1");
    }

    @Test
    public void newDelimiterCanBeDefinedInFirstLine() throws Exception {
        assertEquals(4, stringCalculator.add("//#\n2#2"));
    }
}
