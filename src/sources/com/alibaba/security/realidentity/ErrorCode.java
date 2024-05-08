package com.alibaba.security.realidentity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ErrorCode {
    public String code;
    public String msg;
    public String subCode;

    public ErrorCode(String str, String str2, String str3) {
        this.code = str;
        this.subCode = str2;
        this.msg = str3;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getSubCode() {
        return this.subCode;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setSubCode(String str) {
        this.subCode = str;
    }
}
