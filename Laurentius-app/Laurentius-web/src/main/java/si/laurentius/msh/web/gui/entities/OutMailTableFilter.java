/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package si.laurentius.msh.web.gui.entities;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jože Rihtaršič
 */
public class OutMailTableFilter {

  /**
   *
   */
  protected String action;

  /**
   *
   */
  protected String conversationId;
  protected BigInteger id;
  protected String messageId;

  /**
   *
   */
  protected String receiverEBox;
  protected String refToMessageId;

  /**
   *
   */
  protected List<String> senderEBoxList = new ArrayList<>();
  protected String senderMessageId;

  /**
   *
   */
  protected String service;

  /**
   *
   */
  protected String status;

  /**
   *
   */
  protected String subject;

  /**
   *
   */
  protected Date submittedDateFrom;

  /**
   *
   */
  protected Date submittedDateTo;
  /**
   *
   * @return
   */
  public String getAction() {
    return action;
  }
  /**
   *
   * @return
   */
  public String getConversationId() {
    return conversationId;
  }

  public BigInteger getId() {
    return id;
  }


  public String getMessageId() {
    return messageId;
  }
  /**
   *
   * @return
   */
  public String getReceiverEBox() {
    return receiverEBox;
  }

  public String getRefToMessageId() {
    return refToMessageId;
  }
  /**
   *
   * @return
   */
  public List<String> getSenderEBoxList() {
    return senderEBoxList;
  }

  public String getSenderMessageId() {
    return senderMessageId;
  }


  /**
   *
   * @return
   */
  public String getService() {
    return service;
  }

  /**
   *
   * @return
   */
  public String getStatus() {
    return status;
  }

  /**
   *
   * @return
   */
  public String getSubject() {
    return subject;
  }

  /**
   *
   * @return
   */
  public Date getSubmittedDateFrom() {
    return submittedDateFrom;
  }

  /**
   *
   * @return
   */
  public Date getSubmittedDateTo() {
    return submittedDateTo;
  }

  /**
   *
   * @param action
   */
  public void setAction(String action) {
    this.action = action;
  }

  /**
   *
   * @param conversationId
   */
  public void setConversationId(String conversationId) {
    this.conversationId = conversationId;
  }
  public void setId(BigInteger id) {
    this.id = id;
  }
  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  /**
   *
   * @param receiverEBox
   */
  public void setReceiverEBox(String receiverEBox) {
    this.receiverEBox = receiverEBox;
  }
  public void setRefToMessageId(String refToMessageId) {
    this.refToMessageId = refToMessageId;
  }
  public void setSenderMessageId(String senderMessageId) {
    this.senderMessageId = senderMessageId;
  }

  /**
   *
   * @param service
   */
  public void setService(String service) {
    this.service = service;
  }

  /**
   *
   * @param st
   */
  public void setStatus(String st) {
    this.status = st;
  }

  /**
   *
   * @param subject
   */
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   *
   * @param submittedDateFrom
   */
  public void setSubmittedDateFrom(Date submittedDateFrom) {
    this.submittedDateFrom = submittedDateFrom;
  }

  /**
   *
   * @param submittedDateTo
   */
  public void setSubmittedDateTo(Date submittedDateTo) {
    this.submittedDateTo = submittedDateTo;
  }

  @Override
  public String toString() {
    return "OutMailTableFilter{" + "action=" + action + ", conversationId=" + conversationId +
        ", id=" + id + ", messageId=" + messageId + ", receiverEBox=" + receiverEBox +
        ", refToMessageId=" + refToMessageId + ", senderEBoxList=" + senderEBoxList +
        ", senderMessageId=" + senderMessageId + ", service=" + service + ", status=" + status +
        ", subject=" + subject + ", submittedDateFrom=" + submittedDateFrom + ", submittedDateTo=" +
        submittedDateTo + '}';
  }


}
