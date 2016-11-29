/*
 * Copyright 2015, Supreme Court Republic of Slovenia
 * 
 * Licensed under the EUPL, Version 1.1 or – as soon they will be approved by the European
 * Commission - subsequent versions of the EUPL (the "Licence"); You may not use this work except in
 * compliance with the Licence. You may obtain a copy of the Licence at:
 * 
 * https://joinup.ec.europa.eu/software/page/eupl
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the Licence
 * is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the Licence for the specific language governing permissions and limitations under
 * the Licence.
 */
package si.laurentius.commons.interfaces.exception;

/**
 *
 * @author Joze Rihtarsic <joze.rihtarsic@sodisce.si>
 */
public class InMailProcessException extends Exception {

  int miCode;

  ProcessExceptionCode nTEC;

  /**
   *
   * @param tc
   */
  public InMailProcessException(ProcessExceptionCode tc) {
    super(tc.getDesc());
    nTEC = tc;
  }

  /**
   *
   * @param tc
   * @param message
   */
  public InMailProcessException(ProcessExceptionCode tc, String message) {
    super(message);
    nTEC = tc;
  }

  /**
   *
   * @param tc
   * @param message
   * @param cause
   */
  public InMailProcessException(ProcessExceptionCode tc, String message, Throwable cause) {
    super(message, cause);
    nTEC = tc;
  }

  /**
   *
   * @param tc
   * @param cause
   */
  public InMailProcessException(ProcessExceptionCode tc, Throwable cause) {
    super(cause);
    nTEC = tc;
  }

  /**
   *
   * @param tc
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public InMailProcessException(ProcessExceptionCode tc, String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
    nTEC = tc;
  }

  /**
     *
     */
  public enum ProcessExceptionCode {

    /**
         *
         */
    InitException(1, "Init exception"),

    /**
         *
         */
    ProcessException(2, "Execution error"), ;

    int iCode;
    String strDesc;

    ProcessExceptionCode(int i, String desc) {
      iCode = i;
      strDesc = desc;
    }

    /**
     *
     * @return
     */
    public int getCode() {
      return iCode;
    }

    /**
     *
     * @return
     */
    public String getDesc() {
      return strDesc;
    }

  }

}
