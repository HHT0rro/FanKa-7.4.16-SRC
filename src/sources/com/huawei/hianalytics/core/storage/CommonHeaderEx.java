package com.huawei.hianalytics.core.storage;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CommonHeaderEx {
    public String commonHeaderEx;
    public String evtExHashCode;

    public CommonHeaderEx() {
    }

    public String getCommonHeaderEx() {
        String str = this.commonHeaderEx;
        return str == null ? "" : str;
    }

    public String getEvtExHashCode() {
        String str = this.evtExHashCode;
        return str == null ? "" : str;
    }

    public void setCommonHeaderEx(String str) {
        this.commonHeaderEx = str;
    }

    public void setEvtExHashCode(String str) {
        this.evtExHashCode = str;
    }

    public CommonHeaderEx(String str, String str2) {
        this.evtExHashCode = str;
        this.commonHeaderEx = str2;
    }
}
