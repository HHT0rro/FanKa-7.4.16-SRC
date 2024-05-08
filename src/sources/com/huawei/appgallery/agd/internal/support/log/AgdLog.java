package com.huawei.appgallery.agd.internal.support.log;

import android.text.TextUtils;
import android.util.Log;
import org.apache.commons.lang3.CharUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AgdLog {
    public static final AgdLog LOG = new AgdLog();

    public final void a(int i10, String str, String str2, Throwable th) {
        if (str2 == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = '[' + str + "] " + str2;
        }
        if (th != null) {
            str2 = str2 + th.getMessage();
        }
        if (b(i10)) {
            Log.println(i10, "AgdLog", str2.replace('\n', '_').replace(CharUtils.CR, '_'));
        }
    }

    public final boolean b(int i10) {
        return i10 > 3;
    }

    public void d(String str, String str2) {
        a(3, str, str2, null);
    }

    public void d(String str, String str2, Throwable th) {
        a(3, str, str2, th);
    }

    public void e(String str, String str2) {
        a(6, str, str2, null);
    }

    public void e(String str, String str2, Throwable th) {
        a(6, str, str2, th);
    }

    public void i(String str, String str2) {
        a(4, str, str2, null);
    }

    public void i(String str, String str2, Throwable th) {
        a(4, str, str2, th);
    }

    public void w(String str, String str2) {
        a(5, str, str2, null);
    }

    public void w(String str, String str2, Throwable th) {
        a(5, str, str2, th);
    }
}
