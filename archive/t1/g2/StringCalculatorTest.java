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

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author <a href="mailto:hagen.zahn@torex.com">hagen.zahn</a>
 * @version $Revision$ $Date$ $Author$
 */
public class StringCalculatorTest {

    private StringCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new StringCalculator();
    }

    @Test
    public void emptyStringShouldGetZero() throws Exception {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void oneStringNumberShouldBeTheSameInt() throws Exception {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void numberDotNumberStringShouldBeSum() throws Exception {
        assertEquals(4, calculator.add("2.2"));
    }

    @Test
    public void cascadedAddition() throws Exception {
        calculator.add("1.1");
        assertEquals(7, calculator.add("2.3"));
    }

    @Test(expected = Exception.class)
    public void checkNegativeNumber() throws Exception {
        calculator.add("-23.-5");
    }

    @Test
    public void lineBreakIsAValidDelimiter() throws Exception {
        assertEquals(5, calculator.add("2\n3"));
    }

    @Test
    public void differentDelimiterAtTheBeginningOfTheLine() throws Exception {
        assertEquals(11, calculator.add("//+\n5+6"));
    }

    @Test(expected = Exception.class)
    public void newLineAfterDelimiterDefinition() throws Exception {
        calculator.add("//+\t5+6");
    }

}