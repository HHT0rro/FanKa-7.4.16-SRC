package com.alibaba.security.realidentity.http.model;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class HttpResponse implements Serializable {
    public String Code;
    public int errorCode;

    public abstract boolean isSuccessful();
}
