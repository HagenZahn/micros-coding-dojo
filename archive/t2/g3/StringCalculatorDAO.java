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
public interface StringCalculatorDAO {
  void persist(int result);
  int restore();
}