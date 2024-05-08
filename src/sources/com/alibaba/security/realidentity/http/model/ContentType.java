package com.alibaba.security.realidentity.http.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum ContentType {
    JSON("application/json"),
    FORM("multipart/form-data");

    public String name;

    ContentType(String str) {
        this.name = str;
    }
}
