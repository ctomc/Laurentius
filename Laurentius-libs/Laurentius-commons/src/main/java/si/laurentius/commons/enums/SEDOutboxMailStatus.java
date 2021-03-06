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
package si.laurentius.commons.enums;

import java.util.ArrayList;
import java.util.List;
import static si.laurentius.commons.enums.SEDInboxMailStatus.values;

/**
 *
 * @author Joze Rihtarsic <joze.rihtarsic@sodisce.si>
 */
public enum SEDOutboxMailStatus {

  /**
   *
   */
  /**
   *
   */
  SUBMITTED("SUBMITTED", "Message is sucessfuly added to SED for transmition.", "orange"),
  
    /**
   *
   */
  PENDING("PENDING", "Message is pending due to inactive receiver.", "purple"),

  /**
   *
   */
  PUSHING("PUSHING", "Message is pushing to receiver MSH", "gray"),

  /**
   *
   */
  PULLREADY("PULLREADY", "Message is waiting for pull signal ", "gray"),

  /**
   *
   */
  SCHEDULE("SCHEDULE", "Shedule for resend", "green"),

  /**
   *
   */
  SENT("SENT", "Message is  sent to receiving MSH", "lightblue"),
  
   /**
   *
   */
  DELIVERED("DELIVERED", "Message is delivered to consumer", "darkblue"),

  /**
   *
   */
  ERROR("ERROR", "Error occured pushing/pulling to receiving MSH", "red"),
  
  /**
   *
   */
  PROCESS("PROCESS", "Message is locked for sending ", "darkgray"),
  
   /**
   *
   */
  FAILED("FAILED", "Mail failed to deliver to receiving MSH ", "darkred"),

  /**
   *
   */
  DELETED("DELETED", "Pošiljka je izbrisana", "black");

  private static final List<String> listOfValues;

  static {
    listOfValues = new ArrayList<>();
    for (SEDOutboxMailStatus enmVal : values()) {
      listOfValues.add(enmVal.getValue());
    }
  }

  public static List<String> listOfValues() {
    return listOfValues;
  }
  
  
  String mstrVal;
  String mstrDesc;
  String mstrColor;

  private SEDOutboxMailStatus(String val, String strDesc, String strColor) {
    mstrVal = val;
    mstrDesc = strDesc;
    mstrColor = strColor;
  }

  /**
   *
   * @return
   */
  public String getValue() {
    return mstrVal;
  }

  /**
   *
   * @return
   */
  public String getDesc() {
    return mstrDesc;
  }

  /**
   *
   * @return
   */
  public String getColor() {
    return mstrColor;
  }

  /**
   *
   * @param strName
   * @return
   */
  public static String getColor(String strName) {

    for (SEDOutboxMailStatus st : values()) {
      if (st.getValue().equals(strName)) {
        return st.getColor();
      }
    }
    return strName;
  }
}
