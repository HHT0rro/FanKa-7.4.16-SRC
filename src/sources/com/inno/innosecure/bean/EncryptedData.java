package com.inno.innosecure.bean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class EncryptedData {
    public byte[] encodedData;
    public String exceptionInfo;
    public int resultCode;

    public EncryptedData(int i10) {
        this.resultCode = i10;
    }

    public byte[] getEncodedData() {
        return this.encodedData;
    }

    public String getExceptionInfo() {
        return this.exceptionInfo;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setEncodedData(byte[] bArr) {
        this.encodedData = bArr;
    }

    public void setExceptionInfo(String str) {
        this.exceptionInfo = str;
    }

    public void setResultCode(int i10) {
        this.resultCode = i10;
    }
}
