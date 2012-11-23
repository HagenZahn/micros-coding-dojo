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

  private final PersistenceManager<Integer> persistenceManager;

  public StringCalculator(PersistenceManager<Integer> persistenceManager) {
    this.persistenceManager = persistenceManager;
    result = this.persistenceManager.load();
  }

  public int add(String inputString) {
    if (!inputString.isEmpty()) {
      String cleanInputString = getInputWithoutPotentiallyExistingUserDefinedSeparator(inputString);
      char separator = getSeparator(inputString);
      result += calculateSum(splitAtSeparator(cleanInputString, separator));
    }
    persistenceManager.store(result);
    return result;
  }

  private int calculateSum(String[] numbersAsStrings) {
    int result = 0;
    for (String number : numbersAsStrings) {
      Integer value = Integer.valueOf(number);
      checkNegativeNumber(value);
      result += value;
    }
    return result;
  }

  private boolean hasUserDefinedSeparator(String inputString) {
    return inputString.startsWith("//");
  }

  private String getInputWithoutPotentiallyExistingUserDefinedSeparator(String inputString) {
    return hasUserDefinedSeparator(inputString) ? inputString.substring(4) : inputString;
  }

  private char getSeparator(String inputString){
    return hasUserDefinedSeparator(inputString) ? inputString.charAt(2) : '.';
  }

  private String[] splitAtSeparator(String inputString, char separator) {
    return inputString.split("[" + separator + "\\n]");
  }

  private void checkNegativeNumber(Integer value) {
    if (value < 0) {
      throw new IllegalArgumentException();
    }
  }

  public void reset() {
    result = 0;
  }
}
