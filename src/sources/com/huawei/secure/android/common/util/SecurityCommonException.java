package com.huawei.secure.android.common.util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SecurityCommonException extends Exception {

    /* renamed from: c, reason: collision with root package name */
    private static final long f34773c = 1;

    /* renamed from: a, reason: collision with root package name */
    private String f34774a;

    /* renamed from: b, reason: collision with root package name */
    private String f34775b;

    public SecurityCommonException() {
    }

    public String getMsgDes() {
        return this.f34775b;
    }

    public String getRetCd() {
        return this.f34774a;
    }

    public SecurityCommonException(Throwable th) {
        super(th);
    }

    public SecurityCommonException(String str, Throwable th) {
        super(str, th);
    }

    public SecurityCommonException(String str) {
        super(str);
        this.f34775b = str;
    }

    public SecurityCommonException(String str, String str2) {
        this.f34774a = str;
        this.f34775b = str2;
    }
}
