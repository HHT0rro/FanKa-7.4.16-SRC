package com.huawei.hianalytics.core.log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface LogAdapter {
    void init(int i10, String str);

    boolean isLoggable(int i10);

    void println(int i10, String str, String str2);

    void println(int i10, String str, String str2, String str3);
}
