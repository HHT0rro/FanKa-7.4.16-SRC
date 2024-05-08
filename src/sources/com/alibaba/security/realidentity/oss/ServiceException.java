package com.alibaba.security.realidentity.oss;

import com.alibaba.security.realidentity.build.cd;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ServiceException extends Exception {
    private static final long serialVersionUID = 430933593095358673L;
    private String errorCode;
    private String hostId;
    private String partEtag;
    private String partNumber;
    private String rawMessage;
    private String requestId;
    private int statusCode;

    public ServiceException(int i10, String str, String str2, String str3, String str4, String str5) {
        super(str);
        this.statusCode = i10;
        this.errorCode = str2;
        this.requestId = str3;
        this.hostId = str4;
        this.rawMessage = str5;
        cd.a(this);
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getHostId() {
        return this.hostId;
    }

    public String getPartEtag() {
        return this.partEtag;
    }

    public String getPartNumber() {
        return this.partNumber;
    }

    public String getRawMessage() {
        return this.rawMessage;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setPartEtag(String str) {
        this.partEtag = str;
    }

    public void setPartNumber(String str) {
        this.partNumber = str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "[StatusCode]: " + this.statusCode + ", [Code]: " + getErrorCode() + ", [Message]: " + getMessage() + ", [Requestid]: " + getRequestId() + ", [HostId]: " + getHostId() + ", [RawMessage]: " + getRawMessage();
    }
}
