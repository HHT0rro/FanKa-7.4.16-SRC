package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class UpSendMsgReq implements IMessageEntity {

    @Packed
    private String collapseKey;

    @Packed
    private String data;

    @Packed
    private String msgId;

    @Packed
    private String msgType;

    @Packed
    private String packageName;

    @Packed
    private int receiptMode;

    @Packed
    private int sendMode;

    @Packed
    private String to;

    @Packed
    private String token;

    @Packed
    private int ttl;

    public String getCollapseKey() {
        return this.collapseKey;
    }

    public String getData() {
        return this.data;
    }

    public String getMessageId() {
        return this.msgId;
    }

    public String getMessageType() {
        return this.msgType;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getReceiptMode() {
        return this.receiptMode;
    }

    public int getSendMode() {
        return this.sendMode;
    }

    public String getTo() {
        return this.to;
    }

    public String getToken() {
        return this.token;
    }

    public int getTtl() {
        return this.ttl;
    }

    public void setCollapseKey(String str) {
        this.collapseKey = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setMessageId(String str) {
        this.msgId = str;
    }

    public void setMessageType(String str) {
        this.msgType = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setReceiptMode(int i10) {
        this.receiptMode = i10;
    }

    public void setSendMode(int i10) {
        this.sendMode = i10;
    }

    public void setTo(String str) {
        this.to = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTtl(int i10) {
        this.ttl = i10;
    }
}
