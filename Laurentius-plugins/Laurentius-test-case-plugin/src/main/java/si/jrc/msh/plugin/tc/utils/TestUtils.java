/*
* Copyright 2016, Supreme Court Republic of Slovenia 
*
* Licensed under the EUPL, Version 1.1 or – as soon they will be approved by 
* the European Commission - subsequent versions of the EUPL (the "Licence");
* You may not use this work except in compliance with the Licence.
* You may obtain a copy of the Licence at:
*
* https://joinup.ec.europa.eu/software/page/eupl
*
* Unless required by applicable law or agreed to in writing, software 
* distributed under the Licence is distributed on an "AS IS" basis, WITHOUT 
* WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the Licence for the specific language governing permissions and  
* limitations under the Licence.
 */
package si.jrc.msh.plugin.tc.utils;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import si.laurentius.commons.MimeValues;
import si.laurentius.commons.exception.StorageException;
import si.laurentius.commons.utils.SEDLogger;
import si.laurentius.commons.utils.StorageUtils;
import si.laurentius.commons.utils.StringFormater;
import si.laurentius.commons.utils.xml.XMLUtils;
import si.laurentius.msh.outbox.mail.MSHOutMail;
import si.laurentius.msh.outbox.payload.MSHOutPart;
import si.laurentius.msh.outbox.payload.MSHOutPayload;
import si.laurentius.msh.outbox.property.MSHOutProperties;
import si.laurentius.msh.outbox.property.MSHOutProperty;
import si.laurentius.testcase.MailTestCases;

/**
 *
 * @author Jože Rihtaršič
 */
public class TestUtils {

  private static final SEDLogger LOG = new SEDLogger(TestUtils.class);
  public static String ROOT_FOLDER = "${laurentius.home}/test-case/";
  public static String BLOB_FOLDER = ROOT_FOLDER + "/test-pdf/";
  public static String GENERIC_FOLDER = ROOT_FOLDER + "/generic-cases/";
  
  public static String GENERIC_METADATA = GENERIC_FOLDER + "/testcases.xml";
  
  public static File[] mTstFiles = null;
  
  StorageUtils mstrgUtils = new StorageUtils();

  public MSHOutMail createOutMail(int imsgs, String senderBox, String recName, String recBox,
      String service, String action) {

    Random rnd = new Random(Calendar.getInstance().getTimeInMillis());

    return createOutMail(recBox, recName, senderBox,
        TCLookUp.SENDER_NAMES[rnd.nextInt(
            TCLookUp.SENDER_NAMES.length)],
        service, action,
        TCLookUp.SUBJECTS[rnd.nextInt(TCLookUp.SUBJECTS.length)], getRandomFiles(1, 5,
        rnd), String.format("VL %d/2016", rnd.nextInt(10000)));

  }
   public MSHOutMail createOutMail(int imsgs, String senderBox, String recName, String recBox,
      String service, String action,  List<File> lstfiles) {

    Random rnd = new Random(Calendar.getInstance().getTimeInMillis());

    return createOutMail(recBox, recName, senderBox,
        TCLookUp.SENDER_NAMES[rnd.nextInt(
            TCLookUp.SENDER_NAMES.length)],
        service, action,
        TCLookUp.SUBJECTS[rnd.nextInt(TCLookUp.SUBJECTS.length)],lstfiles, String.format("VL %d/2016", rnd.nextInt(10000)));

  }
  
   public MSHOutMail createOutMail( String senderBox, String recName, String recBox,
      String service, String action, File fName) {

    Random rnd = new Random(Calendar.getInstance().getTimeInMillis());

    return createOutMail(recBox, recName, senderBox,
        TCLookUp.SENDER_NAMES[rnd.nextInt(
            TCLookUp.SENDER_NAMES.length)],
        service, action,
        TCLookUp.SUBJECTS[rnd.nextInt(TCLookUp.SUBJECTS.length)], Collections.singletonList(fName),
        String.format("VL %d/2016", rnd.nextInt(10000)));

  }

  public String serialize(Object o)
      throws JAXBException {

    StringWriter sw = new StringWriter();

    JAXBContext carContext = JAXBContext.newInstance(o.getClass());
    Marshaller carMarshaller = carContext.createMarshaller();
    carMarshaller.marshal(o, sw);

    return sw.toString();
  }

  public List<File> getRandomFiles(int imin, int iMax, Random rnd) {

    int i = imin == iMax || imin > iMax ? imin : rnd.nextInt(iMax - imin) +
        imin;
    i = i > 0 ? i : 1;
    List<File> lst = new ArrayList<>();
    File[] testFiles = getTestFiles();
    while (i-- > 0) {
      lst.add(testFiles[rnd.nextInt(testFiles.length)]);
    }
    return lst;
  }

  private MSHOutMail createOutMail(String rcBox, String rcName, String sndBox,
      String sndName,
      String service, String action, String contentDesc, List<File> fls,
      String oprst) {
    long l  = LOG.logStart();

    MSHOutMail om = new MSHOutMail();

    om.setSenderMessageId("SM_ID-" + UUID.randomUUID().toString());
    om.setSubmittedDate(Calendar.getInstance().getTime());
    om.setAction(action);
    om.setService(service);
    om.setReceiverName(rcName);
    om.setReceiverEBox(rcBox);
    om.setSenderName(sndName);
    om.setSenderEBox(sndBox);
    om.setSubject(oprst + " " + contentDesc);
    om.setMSHOutProperties(new MSHOutProperties());
    MSHOutProperty opr = new MSHOutProperty();
    opr.setName("oprst");
    opr.setValue(oprst);
    om.getMSHOutProperties().getMSHOutProperties().add(opr);

    om.setMSHOutPayload(new MSHOutPayload());
    int i = 0;
    for (File f : fls) {
      try {
       
        File fStorage = mstrgUtils.storeInFile( MimeValues.getMimeTypeByFileName(f.getName()), f);
        MSHOutPart op = new MSHOutPart();
        op.setFilename(f.getName());
        
        op.setDescription(i++ == 0 ? "Sklep" : "Priloga");
        op.setFilepath(StorageUtils.getRelativePath(fStorage));        
        op.setMimeType(MimeValues.getMimeTypeByFileName(f.getName()));
        om.getMSHOutPayload().getMSHOutParts().add(op);
      } catch (StorageException ex) {
        LOG.logError(l, ex);
      }
    }

    return om;

  }

  public static File[] getTestFiles() {
    if (mTstFiles == null) {
      
      File f = new File(StringFormater.replaceProperties(BLOB_FOLDER));
      mTstFiles = f.listFiles((File pathname) -> {
        return pathname.isFile() &&
            pathname.getName().toLowerCase().endsWith(".pdf");
      });

    }
    return mTstFiles;
  }
  
  public static MailTestCases getGenericTestCases(){
    MailTestCases mtc = null;
    File f = new File(StringFormater.replaceProperties(GENERIC_METADATA));
    try {
      mtc = (MailTestCases) XMLUtils.deserialize(f, MailTestCases.class);
    } catch (JAXBException ex) {
      LOG.logError(ex.toString(), ex);
    }
    return mtc;
  
  }

}
