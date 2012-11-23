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
    int allSum = 0;
    public int add(String s) {
        String[] parts = getSeperatedNumbers(s);

        for (String part : parts) {
            if (!part.isEmpty()){
                int number = Integer.parseInt(part);

                if (number < 0) {
                    throw new RuntimeException("Negative numbers not allowed!");
                }

                allSum += number;
            }
        }

        return allSum;
    }

    private String[] getSeperatedNumbers(String s) {
        String delimiters = "\\n\\.";
        if (s.startsWith("//")){
            String[] deliparts = s.split("\\n", 2);
            delimiters += deliparts[0].substring(2);
            s = deliparts[1];
        }
        return s.split("[" +delimiters + "]");
    }
}