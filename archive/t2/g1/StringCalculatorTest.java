/*
 * $Id$
 *
 * Copyright: Torex Retail Solutions GmbH
 *            Salzufer 8
 *            10587 Berlin
 *            Germany
 *
 * http://www.torex.com/
 *
 * All Rights Reserved!
 */

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author <a href="mailto:hagen.zahn@torex.com">hagen.zahn</a>
 * @version $Revision$ $Date$ $Author$
 */
public class StringCalculatorTest {

  @Mock
  PersistenceManager<Integer> persistenceManager;

  StringCalculator stringCalculator;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    when(persistenceManager.load()).thenReturn(0);
    stringCalculator = new StringCalculator(persistenceManager);
  }

  @Test
  public void addDotSeparatedNumberString() {
    Assert.assertEquals(5, stringCalculator.add("2.2.1"));
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
    stringCalculator.add("1");
    assertEquals(2, stringCalculator.add("1"));
  }

  @Test
  public void addWithCustomSeparator() {
    assertEquals(2, stringCalculator.add("//$\n1$1"));
  }

  @Test
  public void resetShouldGetZero() {
    stringCalculator.add("2");
    stringCalculator.reset();
    assertEquals(0, stringCalculator.add(""));
  }

  @Test
  public void mustStoreResultAfterAdd() throws Exception {
    stringCalculator.add("2.3");
    verify(persistenceManager).store(5);
  }

  @Test
  public void mustLoadResultInitially() throws Exception {
    verify(persistenceManager, times(1)).load();
  }
}
