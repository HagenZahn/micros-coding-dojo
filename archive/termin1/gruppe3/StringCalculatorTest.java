import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void addDotSeparatedNumberString() {
        Assert.assertEquals(8, stringCalculator.add("2.2.1.3"));
    }

    @Test
    public void addEmptyStringShouldGetZero(){
        Assert.assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void addDotOrNewlineSeparatedNumberString(){
        Assert.assertEquals(6, stringCalculator.add("1\n2.3"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void addNegativeNumberShouldThrowException() throws Exception {
        stringCalculator.add("1.-1");
    }

    @Test
    public void severalAddCalls() {
        stringCalculator.add("1.2");
        assertEquals(10, stringCalculator.add("3.4"));
    }

    @Test
    public void addWithCustomSeparator(){
        assertEquals(7, stringCalculator.add("//$\n3$4"));
    }
}
