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
public enum SEDInterceptorEvent {

  /**
     *
     */
  IN_MESSAGE("InMessage", "Intercept In-message."),

  /**
     *
     */
  OUT_MESSAGE("OutMessage", "Intercept out-message."),

  /**
     *
     */
  IN_FAULT_MESSAGE("InFaultMessage", "Intercept In fault message."),
  
  /**
     *
     */
  OUT_FAULT_MESSAGE("OutFaultMessage", "Intercept out fault message.");

  private static final List<String> listOfValues;

  static {
    listOfValues = new ArrayList<>();
    for (SEDInterceptorEvent enmVal : values()) {
      listOfValues.add(enmVal.getValue());
    }
  }

  public static List<String> listOfValues() {
    return listOfValues;
  }
  
  String mstrVal;
  String mstrDesc;

  private SEDInterceptorEvent(String val, String strDesc) {
    mstrVal = val;
    mstrDesc = strDesc;
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

}
