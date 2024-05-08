package com.bytedance.pangle.log;

import androidx.annotation.Keep;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IZeusLogger {
    void e(String str, String str2, Throwable th);

    void i(String str, String str2);

    void v(String str, String str2);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th);
}
