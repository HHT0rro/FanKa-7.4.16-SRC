package com.alibaba.security.realidentity.http.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum HttpMethod {
    GET("GET", 1),
    POST("POST", 2),
    PUT("PUT", 3),
    DELETE("DELETE", 4),
    PATCH("PATCH", 5);

    private int index;
    private String name;

    HttpMethod(String str, int i10) {
        this.name = str;
        this.index = i10;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.name;
    }
}
