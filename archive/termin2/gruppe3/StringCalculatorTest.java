import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StringCalculatorTest {

  StringCalculator stringCalculator;
  @Mock
  private StringCalculatorDAO stringCalculatorDAOMock;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    stringCalculator  = new StringCalculator(stringCalculatorDAOMock);
    stringCalculator.reset();
  }

  @Test
  public void addDotSeparatedNumberString() {
    Assert.assertEquals(8, stringCalculator.add("2.2.1.3"));
  }

  @Test
  public void addEmptyStringShouldGetZero() {
    Assert.assertEquals(0, stringCalculator.add(""));
  }

  @Test
  public void addDotOrNewlineSeparatedNumberString() {
    Assert.assertEquals(6, stringCalculator.add("1\n2.3"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void addNegativeNumberShouldThrowException() throws Exception {
    stringCalculator.add("1.-1");
  }

  @Test
  public void severalAddCalls() {
    stringCalculator.add("1.2");
    assertEquals(10, stringCalculator.add("3.4"));
  }

  @Test
  public void addWithCustomSeparator() {
    assertEquals(7, stringCalculator.add("//$\n3$4"));
  }

  @Test
  public void reset() {
    stringCalculator.add("1");
    stringCalculator.reset();
    assertEquals(0, stringCalculator.add(""));
  }

  @Test
  public void addShouldPersistResult() {
    stringCalculator.add("1");
    verify(stringCalculatorDAOMock).persist(1);
  }

  @Test
  public void resetShouldPersistResult() {
    // reset has already been called in setup
    verify(stringCalculatorDAOMock).persist(0);
  }

  @Test
  public void addShouldRestoreResult() {
    when(stringCalculatorDAOMock.restore()).thenReturn(42);
    stringCalculator = new StringCalculator(stringCalculatorDAOMock);
    assertEquals(42,stringCalculator.add(""));
  }
}
