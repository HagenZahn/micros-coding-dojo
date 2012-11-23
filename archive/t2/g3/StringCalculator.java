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

/**
 * @author <a href="mailto:hagen.zahn@torex.com">hagen.zahn</a>
 * @version $Revision$ $Date$ $Author$
 */
public class StringCalculator {

  private int result = 0;
  private char separator = '.';
  private String separatedNumberString;
  private final StringCalculatorDAO dao;

  public StringCalculator(StringCalculatorDAO dao) {
    this.dao = dao;
    result = dao.restore();
  }

  public int add(String inputString) {
    if (!inputString.isEmpty()) {
      parseSeperatorAndSeperatedNumberString(inputString);
      String[] numbers = getNumbersFromSeparatedNumberString();
      addNumbersToResult(numbers);
    }
    dao.persist(result);
    return result;
  }

  private void addNumbersToResult(String[] numberArray) {
    for (String number : numberArray) {
      Integer value = Integer.valueOf(number);
      checkNegativeNumber(value);
      result += value;
    }
  }

  private String[] getNumbersFromSeparatedNumberString() {
    return separatedNumberString.split("[" + separator + "\\n]");
  }

  private void parseSeperatorAndSeperatedNumberString(String inputString) {
    separatedNumberString = inputString;
    if (inputString.startsWith("//")) {
      separatedNumberString = inputString.substring(4);
      separator = inputString.charAt(2);
    }
  }


  private void checkNegativeNumber(Integer value) {
    if (value < 0) {
      throw new IllegalArgumentException();
    }
  }

  public void reset() {
    result = 0;
    dao.persist(result);
  }
}
